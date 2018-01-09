package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GenreService {

    public static void selectAll(List<Genre> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT GenreID, Title FROM Genres ORDER BY GenreID");

        try {
            if (statement != null) {

                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new Genre(results.getInt("GenreID"), results.getString("Title")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }


    public static Genre selectById(int id, DatabaseConnection database) {

        Genre result = null;

        PreparedStatement statement = database.newStatement("SELECT GenreID, Title FROM Genres WHERE GenreID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.runQuery(statement);

                if (results != null) {
                    result = new Genre(results.getInt("GenreID"), results.getString("Title"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }


    @SuppressWarnings("Duplicates")
    public static void deleteById(int id, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("DELETE FROM Genres WHERE GenreID = ?");

        try {
            if (statement != null) {
                statement.setInt(1, id);
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database deletion error: " + resultsException.getMessage());
        }
    }


    public static void save(Genre itemToSave, DatabaseConnection database) {

        Genre existingItem = null;
        if (itemToSave.getGenreId() != 0) existingItem = selectById(itemToSave.getGenreId(), database);

        try {
            if (existingItem == null) {
                PreparedStatement statement = database.newStatement("INSERT INTO Genres (Title) VALUES (?))");
                statement.setString(1, itemToSave.getGenreTitle());
                database.executeUpdate(statement);
            }
            else {
                PreparedStatement statement = database.newStatement("UPDATE Genres SET Title = ?  WHERE GenreID = ?");
                statement.setString(1, itemToSave.getGenreTitle());
                statement.setInt(2, itemToSave.getGenreId());
                database.executeUpdate(statement);
            }
        } catch (SQLException resultsException) {
            System.out.println("Database saving error: " + resultsException.getMessage());
        }
    }
}
