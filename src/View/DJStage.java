package View;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DJStage {

    static Pane parent;
    public static TextField userBPM;

    public DJStage(Pane theParent) {

        Stage stage = new Stage();
        parent = theParent;
        parent.setDisable(true);
        start(stage);

    }

    public void start(Stage stage) {

        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 300);
        stage.setTitle("Auto-DJ");
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent we) -> closeStage(stage));
        stage.show();

        Label selectBpmMessage = new Label("Please enter your desired base BPM.");
        root.getChildren().add(selectBpmMessage);

        userBPM = new TextField();
        root.getChildren().add(userBPM);

    }

    public void closeStage(Stage stage) {

        parent.setDisable(false);
        stage.close();

    }

}