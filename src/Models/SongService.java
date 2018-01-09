package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SongService {

    public static void selectAll(List<Song> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT SongID, GenreID, AlbumID, Title, Length, BPM, SongFileName FROM Songs ORDER BY SongID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Song(results.getInt("SongID"), results.getInt("GenreID"), results.getInt("AlbumID"), results.getString("Title"), results.getDouble("Length"), results.getInt("BPM"), results.getString("SongFileName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }


    public static Song selectById(int id, DatabaseConnection database) {

        Song result = null;

        PreparedStatement statement = database.newStatement("SELECT SongID, GenreID, AlbumID, Title, Length, BPM, SongFileName FROM Songs WHERE SongID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Song(results.getInt("SongID"), results.getInt("GenreID"), results.getInt("AlbumID"), results.getString("Title"), results.getDouble("Length"), results.getInt("BPM"), results.getString("SongFileName"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

    @SuppressWarnings("Duplicates")
    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Songs WHERE SongID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }


    public static void save(Song itemToSave, DatabaseConnection database) {

        Song existingItem = null;
        if (itemToSave.getSongId() != 0) existingItem = selectById(itemToSave.getSongId(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Songs (GenreID, AlbumID, Title, Length, BPM, SongFileName) VALUES (?, ?, ?, ?, ?, ?))");
                statement.setInt(1, itemToSave.getGenreId());
                statement.setInt(2, itemToSave.getAlbumId());
                statement.setString(3, itemToSave.getSongTitle());
                statement.setDouble(4, itemToSave.getLength());
                statement.setInt(5, itemToSave.getBpm());
                statement.setString(6, itemToSave.getSongFileName());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Albums SET GenreID = ?, AlbumID = ?, Title = ?, Length = ?, BPM = ?, SongFileName= ? WHERE SongID = ?");
                statement.setInt(1, itemToSave.getGenreId());
                statement.setInt(2, itemToSave.getAlbumId());
                statement.setString(3, itemToSave.getSongTitle());
                statement.setDouble(4, itemToSave.getLength());
                statement.setInt(5, itemToSave.getBpm());
                statement.setString(6, itemToSave.getSongFileName());
                statement.setInt(7, itemToSave.getSongId());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
