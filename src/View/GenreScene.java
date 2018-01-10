package View;

import Controller.MainController;
import Models.DatabaseConnection;
import Models.Genre;
import Models.GenreService;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class GenreScene {

    public static ScrollPane centreDisplay(DatabaseConnection database, Pane root, MainController controller) {

        ArrayList<Genre> allTheGenres = new ArrayList<>();
        GenreService.selectAll(allTheGenres, database);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);

        TilePane tilePane = new TilePane();
        tilePane.prefWidthProperty().bind(root.widthProperty());
        tilePane.prefHeightProperty().bind(root.heightProperty());
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPadding(new Insets(20));
        scrollPane.setContent(tilePane);

        for(Genre g: allTheGenres) {
            Button genreButton = new Button(g.toString());
            genreButton.setPrefSize(100, 100);
            genreButton.setOnAction((ActionEvent ae) -> controller.showSongs("WHERE GenreId = " + g.getGenreId()));
            tilePane.getChildren().add(genreButton);
        }

        return scrollPane;
    }
}
