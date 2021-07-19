import controller.GameController;
import gameErrors.IllegalMoveException;
import gameErrors.IllegalPlayerException;
import model.Status;
import model.Player;
import service.GameManagerService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main {

    public static void main(String args[]) throws Exception {

        File file = new File("D:\\Anand\\Github\\Design\\TicTacToe\\src\\main\\java\\testcase2.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int playercount=0;
        Player p[]=new Player[2];
        while ((st = br.readLine()) != null) {
            if (st.charAt(0) != '#') {
                String[] nameType = st.split(" ");
                p[0] = new Player(nameType[0], nameType[1].charAt(0));
                st = br.readLine();
                nameType = st.split(" ");
                p[1] = new Player(nameType[0], nameType[1].charAt(0));
                break;
            }
        }
        GameManagerService gameManagerService=new GameManagerService(p);
        GameController gameController=new GameController(gameManagerService);
        while ((st = br.readLine()) != null){
            if(st.charAt(0)!='#'){
                String[] typeLocation = st.split(" ");
                gameController.nextmove(typeLocation[0],typeLocation[1],typeLocation[2]);
                gameController.printBoard();
                if(gameController.getstatus()!= Status.ONGOING) {
                    System.out.println(gameController.getstatus());
                    break;
                }else{
                    System.out.println(gameController.getstatus());
                }
            }
        }

    }
}
