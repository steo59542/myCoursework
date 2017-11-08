import Models.Album;
import Models.AlbumService;
import Models.DatabaseConnection;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    public static BorderPane root;
    public static DatabaseConnection database;

    @Override
    public void start(Stage stage) throws Exception {

        database = new DatabaseConnection("MusicPlayerDatabase.db");

        root = new BorderPane();

        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Music Player");
        stage.setScene(scene);
        stage.show();

        root.setLeft(CommonControls.sceneSelector());
        root.setTop(CommonControls.toolbar());
        root.setBottom(CommonControls.playControls());
        root.setCenter(SongsScene.centreDisplay());



        ArrayList<Album> testList = new ArrayList<>();

        AlbumService.selectAll(testList, database);

        for(Album a: testList){
            System.out.println(a);
        }



    }

    public static void showPlaylists() {

        root.setCenter(PlaylistScene.centreDisplay());

    }

    public static void showSongs() {

        root.setCenter(SongsScene.centreDisplay());

    }

    public static void showArtists() {

        root.setCenter(ArtistScene.centreDisplay());

    }

    public static void showGenres() {

        root.setCenter(GenreScene.centreDisplay());

    }

    public static void openNewStage() {
        DJStage newStage = new DJStage(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
