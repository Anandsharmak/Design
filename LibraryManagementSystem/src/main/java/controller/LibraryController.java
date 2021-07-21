package controller;

import service.LibraryManager;

public class LibraryController {
    LibraryManager libraryManager;
    public LibraryController() {
        libraryManager=new LibraryManager();
    }

    public void createLibrary(int id,int rackno){
        libraryManager.createLibrary(id,rackno);
        Constant.CurrentLibraryId=id;
    }
}
