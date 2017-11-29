package View;

import Models.DatabaseConnection;
import Models.Genre;
import Models.GenreService;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class GenreScene {

    public static ScrollPane centreDisplay(DatabaseConnection database, Pane root) {

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
            Button exampleButton = new Button(g.toString());
            exampleButton.setPrefSize(100, 100);
            tilePane.getChildren().add(exampleButton);
        }

        return scrollPane;
    }
}
