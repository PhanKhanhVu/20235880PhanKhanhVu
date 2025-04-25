package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 1000;
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media m) {
        if (!itemsInStore.contains(m)) {
            if (itemsInStore.size() < MAX_ITEMS_IN_STORE) {
                itemsInStore.add(m);
                System.out.println(m.getTitle() + " has been added to the store.");
            } else {
                System.out.println("The store is almost full.");
            }
        } else {
            System.out.println(m.getTitle() + " is already in the store.");
        }
    }

    public void removeMedia(Media m) {
        if (itemsInStore.remove(m)) {
            System.out.println(m.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(m.getTitle() + " is not found in the store.");
        }
    }

    public void printStore() {
        System.out.println("*********************** STORE ***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("*****************************************************");
    }

    public Media findByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.isMatch(title)) {
                return m;
            }
        }
        return null;
    }
}