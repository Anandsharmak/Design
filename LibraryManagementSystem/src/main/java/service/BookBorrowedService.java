package service;

import model.BookCopy;

import java.util.*;


public class BookBorrowedService {
    TreeSet<BookCopy> bookBorrowMap;

    public BookBorrowedService() {
        this.bookBorrowMap = new TreeSet<BookCopy>(new Comparator<BookCopy>() {
            @Override
            public int compare(BookCopy o1, BookCopy o2) {
                return o2.getIntegerId()-o1.getIntegerId();
            }
        });
    }

    public TreeSet<BookCopy> getBookBorrowMap() {
        return bookBorrowMap;
    }

    public void setBookBorrowMap(BookCopy bookCopy) {
        this.bookBorrowMap = bookBorrowMap;
    }
}
