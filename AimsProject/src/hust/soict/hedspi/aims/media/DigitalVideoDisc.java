package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDVDs = 0;

    public DigitalVideoDisc(String title) {
        super(++nbDVDs, title, "Unknown", "Unknown", 0, 0f);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(++nbDVDs, title, category, "Unknown", 0, cost);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(++nbDVDs, title, category, director, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDVDs, title, category, director, length, cost);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}