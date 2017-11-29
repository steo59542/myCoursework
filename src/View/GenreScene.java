package View;

import Models.DatabaseConnection;
import Models.Genre;
import Models.GenreService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class GenreScene {

    public static ScrollPane centreDisplay(DatabaseConnection database, Pane root) {

        ArrayList<Genre> allTheGenres = new ArrayList<>();
        GenreService.selectAll(allTheGenres, database);

        /*GridPane centrePane = new GridPane();
        centrePane.setHgap(10);
        centrePane.setVgap(10);
        centrePane.setPadding(new Insets(10));

        int x = 0;
        int y = 0;

        for(Genre g: allTheGenres) {

            Button exampleButton = new Button(g.toString());
            exampleButton.setPrefSize(100, 100);
            centrePane.add(exampleButton, x, y);

            x += 1;
            if (x == 10) {
                x = 0;
                y += 1;
            }

        }

        centrePane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centrePane, Pos.CENTER);*/

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);

        TilePane tilePane = new TilePane();
        tilePane.prefWidthProperty().bind(root.widthProperty());
        tilePane.prefHeightProperty().bind(root.heightProperty());
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPadding(new Insets(20));
        scrollPane.setContent(tilePane);

        for (int i = 1; i <= 256; i++) {
            Button exampleButton = new Button(Integer.toString(i));
            exampleButton.setPrefSize(100, 100);
            tilePane.getChildren().add(exampleButton);
        }

        return scrollPane;
    }
}
