package Models;

public class Genre {

    private int genreId;
    private String genreTitle;

    public Genre(int genreId, String genreTitle) {
        this.genreId = genreId;
        this.genreTitle = genreTitle;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String title) {
        this.genreTitle = genreTitle;
    }

    @Override
    public String toString() {
        return genreTitle;
    }
}
