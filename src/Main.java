
import Controller.MainController;
import Models.Album;
import Models.AlbumService;
import Models.DatabaseConnection;
import View.CommonControls;
import View.SongsScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    private static BorderPane root;
    private static DatabaseConnection database;

    @Override
    public void start(Stage stage) throws Exception {

        database = new DatabaseConnection("MusicPlayerDatabase.db");

        root = new BorderPane();

        MainController controller = new MainController(root, database);

        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Music Player");
        stage.setScene(scene);
        stage.show();

        root.setLeft(CommonControls.sceneSelector(controller));
        root.setTop(CommonControls.toolbar());
        root.setBottom(CommonControls.playControls());
        root.setCenter(SongsScene.centreDisplay());



        ArrayList<Album> testList = new ArrayList<>();

        AlbumService.selectAll(testList, database);

        for(Album a: testList){
            System.out.println(a);
        }

    }

        public static void main(String[] args) {
        launch(args);
    }
}
