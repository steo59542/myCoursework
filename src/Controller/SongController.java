package Controller;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SongController {

    public static MediaPlayer songPlayer = null;

    public static ObservableList<SongsView> loadSongsForTable(String whereClause) {

        List<Song> allTheSongs = new ArrayList<>();
        SongService.selectAll(allTheSongs, whereClause, MainController.database);

        List<SongsView> allTheSongViews = new ArrayList<>();

        for (Song s: allTheSongs) {

            Album album = AlbumService.selectById(s.getAlbumId(), MainController.database);
            String albumTitle = album.getAlbumTitle();
            String releaseDate = album.getReleaseDate();

            Artist artist = ArtistService.selectById(album.getArtistId(), MainController.database);
            String name = artist.getName();

            String genreTitle = GenreService.selectById(s.getGenreId(), MainController.database).getGenreTitle();

            SongsView sv = new SongsView(s.getSongId(),
                    s.getGenreId(),
                    s.getAlbumId(),
                    artist.getArtistId(),
                    s.getSongTitle(),
                    name,
                    albumTitle,
                    genreTitle,
                    s.getLength(),
                    s.getBpm(),
                    releaseDate,
                    s.getSongFileName());

            allTheSongViews.add(sv);

        }

        return FXCollections.observableList(allTheSongViews);

    }

    public static void playSong()  {

        File songFile = new File("CourseworkSongs\\01 - speed trials.mp3");    // Music folder should be in project root, not in 'src'
        if (songFile.isFile()) {
            Media songMedia = new Media(songFile.toURI().toString());
            songPlayer = new MediaPlayer(songMedia);
            songPlayer.play();
        } else {
            System.out.println("File error.");
        }

    }

    public static void pauseSong()  {

        if (songPlayer != null) {
            songPlayer.pause();
        }

    }

}
