package Controller;

import Models.*;
import View.CommonControls;
import View.SongsScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SongController {

    public static MediaPlayer songPlayer = null;
    public static boolean playing = false;

    private static String songFilename = null;
    private static long lastClick = 0;

    public static void setSongFilename(String songFilename) {

        long now = System.currentTimeMillis();
        long delay = now - lastClick;

        boolean playNow = false;

        if (songFilename.equals(SongController.songFilename) && delay < 500) playNow = true;

        SongController.songFilename = songFilename;

        if (playNow) {
            if (songPlayer != null) songPlayer.stop();
            songPlayer = null;
            playing = false;
            playSong();
        }

        lastClick = now;

    }

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

    public static void changeTrack(int direction) {

        List<SongsView> songList = SongsScene.songTable.getItems();
        int currentSong = SongsScene.songTable.getSelectionModel().getSelectedIndex();
        if (currentSong == -1) return;
        int requestedSong = currentSong + direction;
        if (requestedSong < 0 || requestedSong > songList.size() - 1) return;
        SongsScene.songTable.getSelectionModel().select(requestedSong);

        if (playing) {
            SongController.songFilename = SongsScene.songTable.getSelectionModel().getSelectedItem().getSongFileName();
            if (songPlayer != null) songPlayer.stop();
            songPlayer = null;
            playing = false;
            playSong();
        }

    }

    public static void setVolume(Number v, boolean mute) {
        if (mute) CommonControls.volume.setValue(0.0);
        if (songPlayer != null) songPlayer.setVolume(v.doubleValue() / 100.0);
    }

    public static void playSong()  {

        if (songFilename == null) {

            System.out.println("No file selected!!");

        } else {

            if (playing) {

                pauseSong();

            } else {

                if (songPlayer == null) { // PREPARE IF NEEDED
                    File songFile = new File("CourseworkSongs/"+ songFilename);    // Music folder should be in project root, not in 'src'
                    if (songFile.isFile()) {
                        Media songMedia = new Media(songFile.toURI().toString());
                        songPlayer = new MediaPlayer(songMedia);
                    } else {
                        System.out.println("File error.");
                    }
                }

                if (songPlayer != null) { // PLAY
                    songPlayer.setVolume(CommonControls.volume.getValue() / 100.0);
                    songPlayer.play();
                    playing = true;
                    CommonControls.play.setText("pause");
                }

            }
        }
    }

    public static void pauseSong()  {

        if (songPlayer != null) { // PAUSE
            songPlayer.pause();
            playing = false;
            CommonControls.play.setText("play");
        }

    }

}
