import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {

    public static BorderPane root;

    @Override
    public void start(Stage stage) throws Exception {

        root = new BorderPane();

        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Music Player");
        stage.setScene(scene);
        stage.show();

        root.setLeft(CommonControls.sceneSelector());
        root.setTop(CommonControls.toolbar());
        root.setBottom(CommonControls.playControls());
        root.setCenter(SongsScene.centreDisplay());

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

    public static void main(String[] args) {
        launch(args);
    }
}
