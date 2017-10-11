import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ArtistScene {

    static VBox centreDisplay() {

        VBox centerPane = new VBox(20);
        Label centrebit = new Label("I AM THE ARTIST CENTRE BIT!!!");
        centerPane.getChildren().add(centrebit);

        centerPane.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerPane, Pos.CENTER);

        return centerPane;
    }
}
