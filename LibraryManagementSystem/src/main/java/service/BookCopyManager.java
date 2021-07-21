package service;

import model.Book;
import model.BookCopy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookCopyManager {
    HashMap<String, List<BookCopy>> bookCopyMap;

    public BookCopyManager(){
        bookCopyMap=new HashMap<>();
    }

    public void putBookCopyByBookId(String BookId, BookCopy bookCopy){
         bookCopyMap.get(BookId).add(bookCopy);

    }

    public List<BookCopy> GetBookCopyByBookId(String BookId){
        return bookCopyMap.get(BookId);

    }
}
