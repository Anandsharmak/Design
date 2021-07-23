package service;

import model.BookCopy;

import java.util.*;


public class BookBorrowedService {
    //user id to tree
    static HashMap<String,TreeSet<BookCopy>> bookBorrowMap=new HashMap<>();

    public static TreeSet<BookCopy> getBookBorrowMap(String useriD) {
        return bookBorrowMap.get(useriD);
    }

    public static void BookBorrow(String userId,BookCopy bookCopy) {
        if(bookBorrowMap.containsKey(userId)){

        }
        else {
            TreeSet treeSet = new TreeSet<BookCopy>(new Comparator<BookCopy>() {
                @Override
                public int compare(BookCopy o1, BookCopy o2) {
                    return (o2.getBookCopyid().compareTo(o1.getBookCopyid()));
                }
            });
            bookBorrowMap.put(userId,treeSet);
        }
        bookBorrowMap.get(userId).add(bookCopy);

    }

    public static void print() {
        System.out.println("Book Borrow Slots");
        for (String key : bookBorrowMap.keySet()) {
            TreeSet<BookCopy> value = bookBorrowMap.get(key);
            Iterator<BookCopy> iterator = value.iterator();
            System.out.print(key + " ");
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }
}
