package controller;

import LibraryException.BOOK_UNAVILABLE;
import LibraryException.INVALIDBOOKCOPYID;
import model.Book;
import model.BookCopy;
import service.BookBorrowedService;
import service.BookCopyManager;
import service.LibraryManager;
import service.RackManagerService;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class BookController {
    BookCopyManager bookCopyManager;


    public BookController() {
        bookCopyManager=new BookCopyManager();
    }

    public void addBook(String bookId, String author,
                        String publisher,String bookCopyId) {

        Book book=new Book(bookId,Arrays.asList(author.split(","))
                ,Arrays.asList(publisher.split(",")));

        List<String> BookCopyiDs=Arrays.asList(bookCopyId.split(","));
        for(int i=0;i<BookCopyiDs.size();i++) {
            try {
                int rackno= RackManagerService.getEmptyRackSlot();
                bookCopyManager.putBookCopyByBookId(bookId, book, BookCopyiDs.get(i),rackno);
                System.out.println("Added Book to rack: "+rackno);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public void RemoveBookCopy(String bookCopyid) throws INVALIDBOOKCOPYID {
        try {
            BookCopy bookCopy=bookCopyManager.removeBookCopyid(bookCopyid);
            int rackNumber=bookCopy.getRackNumber();
            RackManagerService.AddRackNoTolist(bookCopy.getRackNumber());
            bookCopy.setRackNumber(-1);
            System.out.println("Removed book copy: "+bookCopy.getBookCopyid()+" from rack:"
            +rackNumber);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void borrowBook(String id,String userId,String date) throws INVALIDBOOKCOPYID, BOOK_UNAVILABLE {
        try {
            BookCopy bookCopy = bookCopyManager.borrowBook(id);
            RackManagerService.AddRackNoTolist( bookCopy.getRackNumber());
            BookBorrowedService.BookBorrow(userId, bookCopy);
            System.out.println("Borrowed Book to rack: "+bookCopy.getRackNumber());
            bookCopy.setRackNumber(-1);
            bookCopy.setBookDate(date);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void borrowBookCopy(String id,String userId,String date) throws INVALIDBOOKCOPYID, BOOK_UNAVILABLE {
        try {
            BookCopy bookCopy=bookCopyManager.borrowBookCopy(id);;
            RackManagerService.AddRackNoTolist( bookCopy.getRackNumber());
            BookBorrowedService.BookBorrow(userId, bookCopy);
            System.out.println("Borrowed Book to rack: "+bookCopy.getRackNumber());
            bookCopy.setRackNumber(-1);
            bookCopy.setBookDate(date);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void printBorrowed(String userId){
        TreeSet<BookCopy> tree = BookBorrowedService.getBookBorrowMap(userId);
        if(tree!=null){
        Iterator<BookCopy> iterator = tree.iterator();
        while (iterator.hasNext()) {
            BookCopy bookCopy=iterator.next();
            System.out.println(bookCopy.getBookCopyid() + " "+bookCopy.getBookDate());
        }
        System.out.println();
    }}

    public void printDebugLogs(String query){

        bookCopyManager.print();
        RackManagerService.print();
        BookBorrowedService.print();
        System.out.println(query);
        System.out.println();

    }
}
