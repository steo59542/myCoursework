package Models;

public class PlaylistEntries {

    private int songId;
    private int playlistId;

    public PlaylistEntries(int songId, int playlistId) {
        this.songId = songId;
        this.playlistId = playlistId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }
}
