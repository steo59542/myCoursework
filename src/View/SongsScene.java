package View;

import Controller.SongController;
import Models.SongsView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SongsScene {

    public static TableView centreDisplay() {

        TableView<SongsView> songTable = new TableView<SongsView>();

        songTable.setPrefWidth(330);
        songTable.setPrefHeight(500);

        TableColumn<SongsView, String> songNameColumn = new TableColumn<>("Song");
        songNameColumn.setCellValueFactory(new PropertyValueFactory<>("songTitle"));
        songNameColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.14));
        songNameColumn.setResizable(true);
        songTable.getColumns().add(songNameColumn);

        TableColumn<SongsView, String> artistNameColumn = new TableColumn<>("Artist");
        artistNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        artistNameColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.14));
        artistNameColumn.setResizable(true);
        songTable.getColumns().add(artistNameColumn);

        TableColumn<SongsView, String> albumNameColumn = new TableColumn<>("Album");
        albumNameColumn.setCellValueFactory(new PropertyValueFactory<>("albumTitle"));
        albumNameColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.14));
        albumNameColumn.setResizable(true);
        songTable.getColumns().add(albumNameColumn);

        TableColumn<SongsView, String> lengthColumn = new TableColumn<>("Length");
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        lengthColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.14));
        lengthColumn.setResizable(true);
        songTable.getColumns().add(lengthColumn);

        TableColumn<SongsView, String> genreNameColumn = new TableColumn<>("Genre");
        genreNameColumn.setCellValueFactory(new PropertyValueFactory<>("genreTitle"));
        genreNameColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.14));
        genreNameColumn.setResizable(true);
        songTable.getColumns().add(genreNameColumn);

        TableColumn<SongsView, String> bpmColumn = new TableColumn<>("BPM");
        bpmColumn.setCellValueFactory(new PropertyValueFactory<>("bpm"));
        bpmColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.14));
        bpmColumn.setResizable(true);
        songTable.getColumns().add(bpmColumn);

        TableColumn<SongsView, String> releaseDateColumn = new TableColumn<>("Release Date");
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        releaseDateColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.14));
        releaseDateColumn.setResizable(true);
        songTable.getColumns().add(releaseDateColumn);

        songTable.setItems(SongController.loadAllSongsForTable());

        return songTable;

    }

}
