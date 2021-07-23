package controller;

import service.LibraryManager;
import service.RackManagerService;

public class LibraryController {
    LibraryManager libraryManager;
    public LibraryController() {
        libraryManager=new LibraryManager();
    }

    public void createLibrary(int rackno){
        //libraryManager.createLibrary(id,rackno);
        RackManagerService.InitRack(rackno);
//        Constant.CurrentLibraryId=id;
    }
}
