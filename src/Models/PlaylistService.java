package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlaylistService {

    public static void selectAll(List<Playlist> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT PlaylistID, Title FROM Genres ORDER BY PlaylistID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Playlist(results.getInt("PlaylistID"), results.getString("Name")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }


    public static Playlist selectById(int id, DatabaseConnection database) {

        Playlist result = null;

        PreparedStatement statement = database.newStatement("SELECT PlaylistID, Name FROM Playlists WHERE PlaylistID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Playlist(results.getInt("PlaylistID"), results.getString("Name"));
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


    public static void save(Playlist itemToSave, DatabaseConnection database) {

        Playlist existingItem = null;
        if (itemToSave.getPlaylistId() != 0) existingItem = selectById(itemToSave.getPlaylistId(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Playlists (Name) VALUES (?))");
                statement.setString(1, itemToSave.getName());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Playlists SET Name = ?  WHERE PlaylistID = ?");
                statement.setString(1, itemToSave.getName());
                statement.setInt(2, itemToSave.getPlaylistId());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
