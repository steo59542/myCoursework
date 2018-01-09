package Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SongsView {

    private int songId;
    private int genreId;
    private int albumId;
    private int artistId;
    private final SimpleStringProperty songTitle;
    private final SimpleStringProperty name;
    private final SimpleStringProperty albumTitle;
    private final SimpleStringProperty genreTitle;
    private final SimpleDoubleProperty length;
    private final SimpleIntegerProperty bpm;
    private final SimpleStringProperty releaseDate;
    private String songFileName;

    public SongsView(int songId, int genreId, int albumId, int artistId, String songTitle, String name, String albumTitle, String genreTitle, double length, int bpm, String releaseDate, String songFileName) {
        this.songId = songId;
        this.genreId = genreId;
        this.albumId = albumId;
        this.artistId = artistId;
        this.songTitle = new SimpleStringProperty(songTitle);
        this.name = new SimpleStringProperty(name);
        this.albumTitle = new SimpleStringProperty(albumTitle);
        this.genreTitle =  new SimpleStringProperty(genreTitle);
        this.length = new SimpleDoubleProperty(length);
        this.bpm  = new SimpleIntegerProperty(bpm);
        this.releaseDate = new SimpleStringProperty(releaseDate);
        this.songFileName = songFileName;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getSongTitle() {
        return songTitle.get();
    }

    public SimpleStringProperty songTitleProperty() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle.set(songTitle);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAlbumTitle() {
        return albumTitle.get();
    }

    public SimpleStringProperty albumTitleProperty() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle.set(albumTitle);
    }

    public String getGenreTitle() {
        return genreTitle.get();
    }

    public SimpleStringProperty genreTitleProperty() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle.set(genreTitle);
    }

    public double getLength() {
        return length.get();
    }

    public SimpleDoubleProperty lengthProperty() {
        return length;
    }

    public void setLength(double length) {
        this.length.set(length);
    }

    public int getBpm() {
        return bpm.get();
    }

    public SimpleIntegerProperty bpmProperty() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm.set(bpm);
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public SimpleStringProperty releaseDateProperty() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate.set(releaseDate);
    }

    public String getSongFileName() {
        return songFileName;
    }

    public void setSongFileName(String songFileName) {
        this.songFileName = songFileName;
    }
}
