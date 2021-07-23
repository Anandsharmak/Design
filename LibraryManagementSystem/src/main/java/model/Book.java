package model;

import java.util.List;

public class Book {
    String bookId;
    List<String> author;

    public Book(Book book) {
        this.bookId = book.bookId;
        this.author = book.author;
        this.publisher = book.publisher;
    }

    public Book(String bookId, List<String> author, List<String> publisher) {
        this.bookId = bookId;
        this.author = author;
        this.publisher = publisher;
    }

    List<String> publisher;
}
