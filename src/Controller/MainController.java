package Controller;

import Models.DatabaseConnection;
import View.*;
import javafx.scene.layout.BorderPane;


public class MainController {

    private BorderPane root;
    private DatabaseConnection database;

    public MainController(BorderPane root, DatabaseConnection database) {
        this.root = root;
        this.database = database;
    }

    public void showPlaylists() {

        root.setCenter(PlaylistScene.centreDisplay());

    }

    public void showSongs() {

        root.setCenter(SongsScene.centreDisplay());

    }

    public void showArtists() {

        root.setCenter(ArtistScene.centreDisplay());

    }

    public void showGenres() {

        root.setCenter(GenreScene.centreDisplay(database, root));

    }

    public void openNewStage() {
        DJStage newStage = new DJStage(root);
    }
}
