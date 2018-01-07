package View;

import Models.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AlbumScene {

    public static ScrollPane centreDisplay(DatabaseConnection database, Pane root) {

        ArrayList<Album> allTheAlbums = new ArrayList<>();
        AlbumService.selectAll(allTheAlbums, database);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);

        TilePane tilePane = new TilePane();
        tilePane.prefWidthProperty().bind(root.widthProperty());
        tilePane.prefHeightProperty().bind(root.heightProperty());
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPadding(new Insets(20));
        scrollPane.setContent(tilePane);

        for (Album a : allTheAlbums) {
            Button albumButton = new Button(a.toString());
            albumButton.setPrefSize(100, 100);
            tilePane.getChildren().add(albumButton);
        }

        return scrollPane;
    }
}
