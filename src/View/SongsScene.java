package View;

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


        TableColumn<SongsView, String> toppingNameColumn = new TableColumn<>("Title");
        toppingNameColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        toppingNameColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.63));
        toppingNameColumn.setResizable(false);
        songTable.getColumns().add(toppingNameColumn);

        TableColumn<SongsView, String> toppingTypeColumn = new TableColumn<>("Type");
        toppingTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        toppingTypeColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.31));
        toppingTypeColumn.setResizable(false);
        songTable.getColumns().add(toppingTypeColumn);

        return songTable;

    }

}
