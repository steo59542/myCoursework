package Models;

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
    private double length;
    private int bpm;
    private final SimpleStringProperty releaseDate;

    public SongsView(int songId, int genreId, int albumId, int artistId, SimpleStringProperty songTitle, SimpleStringProperty name, SimpleStringProperty albumTitle, SimpleStringProperty genreTitle, double length, int bpm, SimpleStringProperty releaseDate) {
        this.songId = songId;
        this.genreId = genreId;
        this.albumId = albumId;
        this.artistId = artistId;
        this.songTitle = songTitle;
        this.name = name;
        this.albumTitle = albumTitle;
        this.genreTitle = genreTitle;
        this.length = length;
        this.bpm = bpm;
        this.releaseDate = releaseDate;
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
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
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
}
