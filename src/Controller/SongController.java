package Controller;

import Models.Song;
import Models.SongService;
import Models.SongsView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SongController {

    public static ObservableList<SongsView> loadAllSongsForTable() {

        List<Song> allTheSongs = new ArrayList<>();
        SongService.selectAll(allTheSongs, MainController.database);

        List<SongsView> allTheSongViews = new ArrayList<>();

        for (Song s: allTheSongs) {

            SongsView sv = new SongsView(s.getSongId(),
                    s.getGenreId(),
                    s.getAlbumId(),
                    0,
                    "a",
                    "b",
                    "c",
                    "d",
                    s.getLength(),
                    s.getBpm(),
                    "e",
                    s.getSongFileName());

            allTheSongViews.add(sv);

        }

        return FXCollections.observableList(allTheSongViews);

    }

}
