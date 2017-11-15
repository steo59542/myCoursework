package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArtistService {

    public static void selectAll(List<Artist> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT ArtistID, Name FROM Artists ORDER BY ArtistID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Artist(results.getInt("ArtistID"), results.getString("Name")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }


    public static Artist selectById(int id, DatabaseConnection database) {

        Artist result = null;

        PreparedStatement statement = database.newStatement("SELECT ArtistID, Name FROM Artists WHERE ArtistID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Artist(results.getInt("ArtistID"), results.getString("Name"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }


    @SuppressWarnings("Duplicates")
    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Artists WHERE ArtistID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }


    public static void save(Artist itemToSave, DatabaseConnection database) {

        Artist existingItem = null;
        if (itemToSave.getArtistId() != 0) existingItem = selectById(itemToSave.getArtistId(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Albums (Name) VALUES (?))");
                statement.setString(1, itemToSave.getName());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Artists SET Name = ?  WHERE AlbumID = ?");
                statement.setString(1, itemToSave.getName());
                statement.setInt(2, itemToSave.getArtistId());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
