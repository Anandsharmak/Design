import controller.BookController;
import controller.LibraryController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class main {
    public static void main(String args[]) throws Exception {

        File file = new File("D:\\Anand\\Github\\Design\\LibraryManagementSystem\\src\\main\\java\\test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String[] all;
        LibraryController libraryController=new LibraryController();
        BookController bookController=new BookController();
        int i=0;
        while ((st = br.readLine()) != null) {
            System.out.println(i+++" "+st);
            all=st.split(" ");

            switch(all[0]){
                case "create_library":
                    libraryController.createLibrary(Integer.parseInt(all[1]));

                    break;

                case "add_book":
                    bookController.addBook(all[1],all[3],all[4],all[5]);
                    break;

                case "print_borrowed":
                    bookController.printBorrowed(all[1]);
                    break;

                case "borrow_book":
                    bookController.borrowBook(all[1],all[2],all[3]);
                    break;

                case "borrow_book_copy":
                    bookController.borrowBookCopy(all[1],all[2],all[3]);
                    break;

                case "remove_book_copy":
                    bookController.RemoveBookCopy(all[1]);
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    break;

            }

            //bookController.printDebugLogs(all[0]);
        }
    }
}


