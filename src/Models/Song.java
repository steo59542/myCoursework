package Models;

public class Song {

    private int songId;
    private int genreId;
    private int albumId;
    private String title;
    private double length;
    private int bpm;
    private String songFileName;

    public Song(int songId, int genreId, int albumId, String title, double length, int bpm, String songFileName) {
        this.songId = songId;
        this.genreId = genreId;
        this.albumId = albumId;
        this.title = title;
        this.length = length;
        this.bpm = bpm;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getSongFileName() {
        return songFileName;
    }

    public void SetSongFileName(int bpm) { this.songFileName = songFileName; }

}
