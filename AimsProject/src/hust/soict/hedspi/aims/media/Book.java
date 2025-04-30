package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media implements Playable {
    private ArrayList<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author added: " + authorName);
        } else {
            System.out.println("Author already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.remove(authorName)) {
            System.out.println("Author removed: " + authorName);
        } else {
            System.out.println("Author not found.");
        }
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }
    @Override
    public void play() {
        System.out.println("Cannot play book: " + getTitle());
    }
    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors + " - " + getCost() + "$";
    }
}