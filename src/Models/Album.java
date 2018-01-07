package Models;

public class Album {

    private int albumId;
    private int artistId;
    private String title;
    private String releaseDate;
    private String albumArtworkFileName;

    public Album(int albumId, int artistId, String title, String releaseDate, String albumArtworkFileName) {
        this.albumId = albumId;
        this.artistId = artistId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.albumArtworkFileName = albumArtworkFileName;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAlbumArtworkFileName() {
        return albumArtworkFileName;
    }

    public void setAlbumArtworkFileName(String albumArtworkFileName) {
        this.albumArtworkFileName = albumArtworkFileName;
    }

    @Override
    public String toString() {
        return title;
    }
}
