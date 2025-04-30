package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, String artist, float cost) {
        super(id, title, category, cost);
        this.artist = artist;
    }

    public String getArtist() { return artist; }

    public void addTrack(Track t) {
        if (!tracks.contains(t)) tracks.add(t);
    }

    public void removeTrack(Track t) {
        tracks.remove(t);
    }

    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    @Override
    public void play() {
        int len = getLength();
        if (len > 0) {
            System.out.println("Playing CD: " + getTitle() + " by " + artist + " - " + len + " minutes");
            tracks.forEach(Track::play);
        } else {
            System.out.println("Cannot play CD: " + getTitle());
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + artist + " - " + getLength() + " minutes - " + getCost() + "$";
    }
}