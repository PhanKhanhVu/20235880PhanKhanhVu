package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nStore Options: ");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back to main menu");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void cartMenu() {
        System.out.println("\nCart Options: ");
        System.out.println("1. Filter medias in cart by id or title");
        System.out.println("2. Remove media from cart");
        System.out.println("3. Play a media in cart");
        System.out.println("4. Place order");
        System.out.println("0. Back to main menu");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        // Thêm sẵn một số DVD
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        int mainOption;
        do {
            showMenu();
            mainOption = Integer.parseInt(sc.nextLine());

            switch (mainOption) {
                case 1 -> { // View store
                    store.printStore();
                    int storeOption;
                    do {
                        storeMenu();
                        storeOption = Integer.parseInt(sc.nextLine());
                        switch (storeOption) {
                            case 1 -> { // See media's detail
                                System.out.print("Enter title to search: ");
                                String title = sc.nextLine();
                                Media found = store.findByTitle(title);
                                if (found != null) {
                                    System.out.println("Found: " + found);
                                } else {
                                    System.out.println("Media not found.");
                                }
                            }
                            case 2 -> { // Add media to cart
                                System.out.print("Enter title to add to cart: ");
                                String title = sc.nextLine();
                                Media media = store.findByTitle(title);
                                if (media != null) {
                                    cart.addMedia(media);
                                } else {
                                    System.out.println("Media not found.");
                                }
                            }
                            case 3 -> { // Play media
                                System.out.print("Enter title to play: ");
                                String title = sc.nextLine();
                                Media media = store.findByTitle(title);
                                if (media instanceof Playable) {
                                    ((Playable) media).play();
                                } else {
                                    System.out.println("This media cannot be played.");
                                }
                            }
                            case 4 -> cart.print();
                        }
                    } while (storeOption != 0);
                }

                case 2 -> { // Update store
                    System.out.print("Enter title of new media: ");
                    String title = sc.nextLine();
                    store.addMedia(new DigitalVideoDisc(title));
                }

                case 3 -> { // See current cart
                    cart.print();
                    int cartOption;
                    do {
                        cartMenu();
                        cartOption = Integer.parseInt(sc.nextLine());
                        switch (cartOption) {
                            case 1 -> {
                                System.out.print("Search by (1) ID or (2) Title? ");
                                int choice = Integer.parseInt(sc.nextLine());
                                if (choice == 1) {
                                    System.out.print("Enter ID: ");
                                    int id = Integer.parseInt(sc.nextLine());
                                    cart.searchById(id);
                                } else {
                                    System.out.print("Enter title: ");
                                    String title = sc.nextLine();
                                    cart.searchByTitle(title);
                                }
                            }
                            case 2 -> {
                                System.out.print("Enter title of media to remove: ");
                                String title = sc.nextLine();
                                Media toRemove = cart.findByTitle(title);
                                if (toRemove != null) {
                                    cart.removeMedia(toRemove);
                                } else {
                                    System.out.println("Media not found in cart.");
                                }
                            }
                            case 3 -> {
                                System.out.print("Enter title to play: ");
                                String title = sc.nextLine();
                                Media media = cart.findByTitle(title);
                                if (media instanceof Playable) {
                                    ((Playable) media).play();
                                } else {
                                    System.out.println("Media not playable.");
                                }
                            }
                            case 4 -> {
                                System.out.println("Order placed!");
                                cart.clearCart();
                            }
                        }
                    } while (cartOption != 0);
                }

                case 0 -> System.out.println("Goodbye!");
                default -> {
                }
            }

        } while (mainOption != 0);
    }
}