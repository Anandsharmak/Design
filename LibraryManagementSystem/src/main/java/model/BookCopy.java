package model;

import java.util.Date;

enum Status{
    AVAILABLE    ,
    UNAVAILABLE
}

public class BookCopy extends Book {
    String bookid;
    int integerId;
    Status status;
    int RackNumber;
    Date BookDate;

    public int getIntegerId() {
        return integerId;
    }

    public BookCopy(String bookid, int integerId, Status status, int rackNumber, Date bookDate) {
        this.bookid = bookid;
        this.integerId = integerId;
        this.status = status;
        RackNumber = rackNumber;
        BookDate = bookDate;
    }

}
