package View;

import Controller.MainController;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CommonControls {

    public static VBox sceneSelector(MainController controller) {

        VBox leftPane = new VBox(20);

        Button songs = new Button("Songs");
        songs.setOnAction((ActionEvent ae) -> controller.showSongs());
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

        Button mute = new Button("mute");
        trackControls.getChildren().add(mute);

        Slider volume = new Slider();
        trackControls.getChildren().add(volume);

        bottomPane.getChildren().add(trackControls);


        bottomPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(bottomPane, Pos.BOTTOM_CENTER);

        return bottomPane;

    }
}
