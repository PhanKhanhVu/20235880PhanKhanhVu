package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);  // Gọi constructor của Media
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Disc - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + " mins - " + getCost() + "$";
    }
}
