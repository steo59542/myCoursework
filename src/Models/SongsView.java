package Models;

import javafx.beans.property.SimpleStringProperty;

public class SongsView {

    private int songId;
    private int genreId;
    private int albumId;
    private final SimpleStringProperty title;
    private double length;
    private int bpm;
    private int artistId;
    private final SimpleStringProperty releaseDate;
    private final SimpleStringProperty name;

    public SongsView(int songId, int genreId, int albumId, SimpleStringProperty title, double length, int bpm, int artistId, SimpleStringProperty releaseDate, SimpleStringProperty name) {
        this.songId = songId;
        this.genreId = genreId;
        this.albumId = albumId;
        this.title = title;
        this.length = length;
        this.bpm = bpm;
        this.artistId = artistId;
        this.releaseDate = releaseDate;
        this.name = name;
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

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
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

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
