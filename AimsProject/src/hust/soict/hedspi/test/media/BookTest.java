package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book(1, "Java Programming", "Education", 29.99f);
        book.addAuthor("James Gosling");
        book.addAuthor("James Gosling"); // test trùng tên
        book.addAuthor("Herbert Schildt");
        book.removeAuthor("John Doe");   // test không có tên
        book.removeAuthor("Herbert Schildt");

        System.out.println(book);
    }
}