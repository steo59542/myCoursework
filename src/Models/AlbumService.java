package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlbumService {

    public static void selectAll(List<Album> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT AlbumID, ArtistID, Title, ReleaseDate, AlbumArtworkFileName FROM Albums ORDER BY AlbumID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Album(results.getInt("AlbumID"), results.getInt("ArtistID"), results.getString("Title"), results.getString("ReleaseDate"), results.getString("AlbumArtworkFileName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }


    public static Album selectById(int id, DatabaseConnection database) {

        Album result = null;

        PreparedStatement statement = database.newStatement("SELECT AlbumID, ArtistID, Title, ReleaseDate, AlbumArtworkFileName FROM Albums WHERE AlbumID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Album(results.getInt("AlbumID"), results.getInt("ArtistID"), results.getString("Title"), results.getString("ReleaseDate"), results.getString("AlbumArtworkFileName"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }


    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Albums WHERE AlbumID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }


    public static void save(Album itemToSave, DatabaseConnection database) {

        Album existingItem = null;
        if (itemToSave.getAlbumId() != 0) existingItem = selectById(itemToSave.getAlbumId(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Albums (ArtistID, Title, ReleaseDate, AlbumArtworkFileName) VALUES (?, ?, ?))");
                statement.setInt(1, itemToSave.getArtistId());
                statement.setString(2, itemToSave.getTitle());
                statement.setString(3, itemToSave.getReleaseDate());
                statement.setString(4, itemToSave.getAlbumArtworkFileName());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Table SET ArtistID = ?, ArtistID = ?, ReleaseDate = ?, AlbumArtworkFileName = ?  WHERE AlbumID = ?");
                statement.setInt(1, itemToSave.getArtistId());
                statement.setString(2, itemToSave.getTitle());
                statement.setString(3, itemToSave.getReleaseDate());
                statement.setString(4, itemToSave.getAlbumArtworkFileName());
                statement.setInt(5, itemToSave.getAlbumId());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
