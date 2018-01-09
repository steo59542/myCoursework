package Controller;

import Models.DatabaseConnection;
import View.*;
import javafx.scene.layout.BorderPane;


public class MainController {

    private BorderPane root;
    public static DatabaseConnection database;

    public MainController(BorderPane root) {
        this.root = root;
        database = new DatabaseConnection("MusicPlayerDatabase.db");
    }

    public void showSongs() {

        root.setCenter(SongsScene.centreDisplay());

    }

    public void showAlbums() {

        root.setCenter(AlbumScene.centreDisplay(database, root));

    }

    public void showArtists() {

        root.setCenter(ArtistScene.centreDisplay(database, root));

    }

    public void showGenres() {

        root.setCenter(GenreScene.centreDisplay(database, root));

    }

    public void showPlaylists() {

        root.setCenter(PlaylistScene.centreDisplay(database, root));

    }

    public void openNewStage() {
        DJStage newStage = new DJStage(root);
    }
}
