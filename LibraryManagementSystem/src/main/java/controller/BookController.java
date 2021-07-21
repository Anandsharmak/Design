package controller;

import service.BookBorrowedService;
import service.BookCopyManager;
import service.LibraryManager;

import java.util.List;

public class BookController {
    BookCopyManager bookManager;
    public BookController() {
        bookManager=new BookCopyManager();
    }
    public void addBook(String Bookid, List<String> author
            ,List<String> publisher,List<String> bookCopyId){

    }
}
