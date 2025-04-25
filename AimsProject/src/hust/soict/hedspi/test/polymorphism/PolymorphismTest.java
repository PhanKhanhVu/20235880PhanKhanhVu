package hust.soict.hedspi.test.polymorphism;

import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;

public class PolymorphismTest {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<>();

        mediaList.add(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        mediaList.add(new Book(2, "Effective Java", "Programming", 49.99f));

        CompactDisc cd = new CompactDisc(3, "Greatest Hits", "Music", "Universal", 29.95f);
        cd.addTrack(new Track("Bohemian Rhapsody", 6));
        cd.addTrack(new Track("Don't Stop Me Now", 4));
        mediaList.add(cd);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}