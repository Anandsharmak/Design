package service;

import LibraryException.BOOK_UNAVILABLE;
import LibraryException.INVALIDBOOKCOPYID;
import model.Book;
import model.BookCopy;
import model.Status;

import java.util.*;
import java.util.stream.Collectors;

public class BookCopyManager {
    //BookId to BookCopymapping
    HashMap<String, List<BookCopy>> bookCopyMap;
    HashMap<String, String> bookCopyiDToBookID;

    public BookCopyManager(){
        bookCopyMap=new HashMap<>();
        bookCopyiDToBookID=new HashMap<>();

    }

    //Bookid to bookcopyid
    public void putBookCopyByBookId(String BookId,Book book,String bookCopyId,int rackno) throws Exception {

        BookCopy bookCopy=new BookCopy(book);
        bookCopy.setBookCopyid(bookCopyId);
        bookCopy.setRackNumber(rackno);
        bookCopyiDToBookID.put(bookCopyId,BookId);
        if(!bookCopyMap.containsKey(BookId))
            bookCopyMap.put(BookId,new LinkedList<>());
        bookCopyMap.get(BookId).add(bookCopy);
    }

    public List<BookCopy> GetBookCopyByBookId(String BookId){
        return bookCopyMap.get(BookId);
    }

    public BookCopy removeBookCopyid(String bookCopyId) throws INVALIDBOOKCOPYID {
        if(bookCopyiDToBookID.containsKey(bookCopyId)) {
            String bookid = bookCopyiDToBookID.get(bookCopyId);
            BookCopy bookCopy = bookCopyMap.get(bookid).stream()
                    .filter(bookCop -> bookCop.getBookCopyid().compareTo(bookCopyId) == 0)
                    .collect(Collectors.toList()).get(0);

            bookCopyMap.get(bookid).removeIf(bookCop->bookCop.getBookCopyid()==bookCopyId);
            bookCopyiDToBookID.remove(bookCopyId);
            return bookCopy;
        }
        else
            throw new INVALIDBOOKCOPYID();

    }

    public BookCopy borrowBook(String bookId) throws INVALIDBOOKCOPYID, BOOK_UNAVILABLE {
        if(bookCopyMap.containsKey(bookId)) {

            Iterator<BookCopy> iterator = bookCopyMap.get(bookId).iterator();

            String bookid="";
            while (iterator.hasNext()) {
                BookCopy bookCopy=iterator.next();
                if(bookCopy.getStatus()== Status.AVAILABLE){
                    bookid=bookCopy.getBookCopyid();
                    break;
                }
            }
            if(bookid=="")
                throw new BOOK_UNAVILABLE();

            BookCopy bookCopy=borrowBookCopy(bookid);
            bookCopy.setStatus(Status.UNAVAILABLE);
            return bookCopy;
        }
        else
            throw new INVALIDBOOKCOPYID();

    }

    public BookCopy borrowBookCopy(String bookCopyId) throws INVALIDBOOKCOPYID, BOOK_UNAVILABLE {
        if(bookCopyiDToBookID.containsKey(bookCopyId)) {

            String bookid = bookCopyiDToBookID.get(bookCopyId);
            BookCopy bookCopy=bookCopyMap.get(bookid).stream()
                    .filter(bookCop->bookCop.getBookCopyid()==bookCopyId)
                    .collect(Collectors.toList()).get(0);

            if(bookCopy.getStatus()==Status.UNAVAILABLE){
                throw new BOOK_UNAVILABLE();
            }

            return bookCopy;

            //bookCopyMap.get(bookid).removeIf(bookCopy->bookCopy.getBookid()==bookCopyId);
            //bookCopyiDToBookID.remove(bookCopyId);

        }
        else
            throw new INVALIDBOOKCOPYID();
    }

    public void print(){
        System.out.println("bookCopyMap");
        for (String key: bookCopyMap.keySet()) {
            List<BookCopy> value = bookCopyMap.get(key);
            Iterator<BookCopy> iterator = value.iterator();
            System.out.print(key + " " );
            while (iterator.hasNext()) {
                System.out.print(iterator.next().getBookCopyid()+" ");
            }
            System.out.println();
        }
        System.out.println("bookCopyiDToBookID");
        for (String key: bookCopyiDToBookID.keySet()) {
            System.out.println(key + " " +bookCopyiDToBookID.get(key));
        }
    }
}
