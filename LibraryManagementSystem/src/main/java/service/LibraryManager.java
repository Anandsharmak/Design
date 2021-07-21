package service;

import model.BookCopy;

import java.util.HashMap;

public class LibraryManager {
    HashMap<Integer, Integer> LibraryMap;

    public LibraryManager(){
        LibraryMap=new HashMap<>();
    }

    public void createLibrary(int libraryId,int rackNo){
        LibraryMap.put(libraryId,rackNo);
    }

    public int getLibraryRackNumber(int libraryId){
        return LibraryMap.get(libraryId);
    }

}
