package Models;

public class Playlist {

    private int playlistId;
    private String name;

    public Playlist(int playlistId, String name) {
        this.playlistId = playlistId;
        this.name = name;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
