package service;

import model.Book;
import model.BookCopy;

import java.util.HashMap;

class SearchManagerService {
    HashMap<String, HashMap<String, Book>> searchMap;

    public Book getBookByAttribute(String attributename,String attributeValue){
        return searchMap.get(attributename).get(attributeValue);
    }

    public void addToSearchMap(String attributename,String attributeValue,Book book){
        HashMap<String, Book> attributeValueToBook=new HashMap<>();
        attributeValueToBook.put(attributeValue,book);
        searchMap.put(attributename,attributeValueToBook);
    }
}
