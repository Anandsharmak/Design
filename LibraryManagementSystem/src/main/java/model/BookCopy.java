package model;

import java.util.Date;
import java.util.List;


public class BookCopy extends Book {
    String bookCopyid;
    int integerId;
    Status status;

    public BookCopy(Book book) {
        super(book);
        status=Status.AVAILABLE;
    }

    int RackNumber;
    String BookDate;

    public void setBookCopyid(String bookid) {
        this.bookCopyid = bookid;
    }

    public void setIntegerId(int integerId) {
        this.integerId = integerId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRackNumber(int rackNumber) {
        RackNumber = rackNumber;
    }

    public void setBookDate(String bookDate) {
        BookDate = bookDate;
    }

    public String getBookCopyid() {
        return bookCopyid;
    }

    public Status getStatus() {
        return status;
    }

    public int getRackNumber() {
        return RackNumber;
    }

    public String getBookDate() {
        return BookDate;
    }

    public int getIntegerId() {
        return integerId;
    }

}
