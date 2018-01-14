package View;

import Controller.MainController;
import Controller.SongController;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class CommonControls {

    public static VBox sceneSelector(MainController controller) {

        VBox leftPane = new VBox(20);

        Button songs = new Button("Songs");
        songs.setOnAction((ActionEvent ae) -> controller.showSongs(""));
        leftPane.getChildren().add(songs);

        Button albums = new Button("Albums");
        albums.setOnAction((ActionEvent ae) -> controller.showAlbums());
        leftPane.getChildren().add(albums);

        Button artists = new Button("Artists");
        artists.setOnAction((ActionEvent ae) -> controller.showArtists());
        leftPane.getChildren().add(artists);

        Button genres = new Button("Genres");
        genres.setOnAction((ActionEvent ae) -> controller.showGenres());
        leftPane.getChildren().add(genres);

        Button playlists = new Button("Playlists");
        playlists.setOnAction((ActionEvent ae) -> controller.showPlaylists());
        leftPane.getChildren().add(playlists);

        Button autoDJ = new Button("Auto-DJ");
        autoDJ.setOnAction((ActionEvent ae) -> controller.openNewStage());
        leftPane.getChildren().add(autoDJ);

        leftPane.setAlignment(Pos.TOP_LEFT);
        BorderPane.setAlignment(leftPane, Pos.CENTER_LEFT);
        return leftPane;

    }

    public static MenuBar toolbar() {

        MenuBar myMenu = new MenuBar();

        Menu numbersMenu = new Menu("Numbers");
        MenuItem numbersItem1 = new MenuItem("One");
        MenuItem numbersItem2 = new MenuItem("Two");
        MenuItem numbersItem3 = new MenuItem("Three");
        numbersMenu.getItems().addAll(numbersItem1, numbersItem2, numbersItem3);

        Menu coloursMenu = new Menu("Colours");
        MenuItem coloursItem1 = new MenuItem("Red");
        MenuItem coloursItem2 = new MenuItem("Green");
        MenuItem coloursItem3 = new MenuItem("Blue");
        coloursMenu.getItems().addAll(coloursItem1, coloursItem2, coloursItem3);

        Menu shapesMenu = new Menu("Shapes");
        MenuItem shapesItem1 = new MenuItem("Triangle");
        MenuItem shapesItem2 = new MenuItem("Square");
        MenuItem shapesItem3 = new MenuItem("Circle");
        shapesMenu.getItems().addAll(shapesItem1, shapesItem2, shapesItem3);

        myMenu.getMenus().addAll(numbersMenu, coloursMenu, shapesMenu);

        return myMenu;

    }

    public static VBox playControls() {

        VBox bottomPane = new VBox();


        HBox runTime = new HBox(20);
        //runTime.setStyle("-fx-background-color: red;");

        Label time = new Label("This is the track time");
        runTime.getChildren().add(time);

        Slider scrubBar = new Slider();
        runTime.getChildren().add(scrubBar);
        HBox.setHgrow(scrubBar, Priority.ALWAYS);

        bottomPane.getChildren().add(runTime);

        HBox emptySpace = new HBox(10);
        //emptySpace.setStyle("-fx-background-color: hotpink;");

        HBox trackControls = new HBox(10);
        //trackControls.setStyle("-fx-background-color: cyan;");
        Button back = new Button("back");
        trackControls.getChildren().add(back);

        trackControls.setAlignment(Pos.CENTER);
        Button play = new Button("play");
        play.setOnAction((ActionEvent ae) -> SongController.playSong());
        trackControls.getChildren().add(play);

        Button forward = new Button("forward");
        trackControls.getChildren().add(forward);

        HBox volumeControls = new HBox(10);
        //volumeControls.setStyle("-fx-background-color: yellow;");
        Button mute = new Button("mute");
        volumeControls.setAlignment(Pos.CENTER_RIGHT);
        volumeControls.getChildren().add(mute);

        Slider volume = new Slider();
        volumeControls.getChildren().add(volume);

        GridPane bottomControls = new GridPane();
        GridPane.setHgrow(emptySpace, Priority.ALWAYS);
        GridPane.setHgrow(trackControls, Priority.ALWAYS);
        GridPane.setHgrow(volumeControls, Priority.ALWAYS);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(33);
        GridPane.setRowIndex(emptySpace, 0);
        GridPane.setColumnIndex(emptySpace, 0);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(34);
        GridPane.setRowIndex(trackControls, 0);
        GridPane.setColumnIndex(trackControls, 1);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(33);
        GridPane.setRowIndex(volumeControls, 0);
        GridPane.setColumnIndex(volumeControls, 2);

        bottomControls.getColumnConstraints().addAll(col1,col2,col3);
        bottomControls.getChildren().addAll(emptySpace, trackControls, volumeControls);

        bottomPane.getChildren().add(bottomControls);

        bottomPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(bottomPane, Pos.BOTTOM_CENTER);

        return bottomPane;

    }
}
