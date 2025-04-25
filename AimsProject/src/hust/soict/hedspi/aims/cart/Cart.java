package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media m) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        } else {
            itemsOrdered.add(m);
            System.out.println("The media has been added");
        }
    }

    public void removeMedia(Media m) {
        if (itemsOrdered.remove(m)) {
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media does not exist");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media m : itemsOrdered) {
            System.out.printf("%d. %s%n", i++, m);
        }
        System.out.printf("Total cost: %.2f%n", totalCost());
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found: " + m);
                return;
            }
        }
        System.out.println("The media does not exist");
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.isMatch(title)) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("The media does not exist");
        }
    }
    public Media findByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.isMatch(title)) {
                return m;
            }
        }
        return null;
    }
    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }
    public void sortMediaByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }
    public void sortMediaByCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }
}