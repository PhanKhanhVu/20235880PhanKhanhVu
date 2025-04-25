package hust.soict.hedspi.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        if (length > 0) {
            System.out.println("Playing Track: " + title + " - " + length);
        } else {
            System.out.println("Cannot play track: " + title);
        }
    }
    @Override
    public String toString() {
        return "Track: " + title + " - " + length + " minutes";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track other = (Track) obj;
        return this.length == other.length &&
                this.title != null &&
                this.title.equalsIgnoreCase(other.title);
    }

}