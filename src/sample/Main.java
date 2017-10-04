package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Music Player");
        stage.setScene(scene);
        stage.show();

        VBox leftPane = new VBox(20);
        Button leftButton1 = new Button("I am left.");
        leftPane.getChildren().add(leftButton1);
        Button leftButton2 = new Button("I am left again.");
        leftPane.getChildren().add(leftButton2);
        root.setLeft(leftPane);
        leftPane.setAlignment(Pos.TOP_LEFT);
        BorderPane.setAlignment(leftPane, Pos.CENTER_LEFT);

        HBox topPane = new HBox(20);
        Button topButton1 = new Button("I am top.");
        topPane.getChildren().add(topButton1);
        Button topButton2 = new Button("I am top again.");
        topPane.getChildren().add(topButton2);
        root.setTop(topPane);
        topPane.setAlignment(Pos.CENTER_LEFT);
        BorderPane.setAlignment(topPane, Pos.TOP_CENTER);

        VBox bottomPane = new VBox(10);

        HBox runTime = new HBox(20);

        Label time = new Label("This is the track time");
        runTime.getChildren().add(time);

        Slider scrubBar = new Slider();
        runTime.getChildren().add(scrubBar);

        bottomPane.getChildren().add(runTime);


        HBox trackControls = new HBox(10);
        Button back = new Button("back");
        trackControls.getChildren().add(back);

        Button play = new Button("play");
        trackControls.getChildren().add(play);

        Button forward = new Button("forward");
        trackControls.getChildren().add(forward);

        bottomPane.getChildren().add(trackControls);

        root.setBottom(bottomPane);
        bottomPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(bottomPane, Pos.BOTTOM_CENTER);



        VBox centerPane = new VBox(20);
        Button centerButton1 = new Button("I am centre.");
        centerPane.getChildren().add(centerButton1);
        Button centerButton2 = new Button("I am centre again.");
        centerPane.getChildren().add(centerButton2);
        root.setCenter(centerPane);
        centerPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerPane, Pos.CENTER);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
