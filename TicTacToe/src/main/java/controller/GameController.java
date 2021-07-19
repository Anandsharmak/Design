package controller;

import gameErrors.IllegalPlayerException;
import model.Status;
import service.GameManagerService;
import service.PrintService;


public class GameController {
    GameManagerService gameManagerService;

    public GameController( GameManagerService gameManagerService){
        this.gameManagerService=gameManagerService;
    }

    public Status getstatus() {
        return gameManagerService.getStatus();
    }

    public void nextmove(String s, String x, String y) throws IllegalPlayerException {
        gameManagerService.nextmove(s.charAt(0),x,y);
    }


    public void printBoard() {
        gameManagerService.printboard();
    }
}
