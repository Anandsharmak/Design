package service;

import model.Player;
import model.Status;

import java.util.Arrays;
import java.util.HashMap;
import gameErrors.IllegalPlayerException;

public class GameManagerService {
    HashMap<Character,Player> players;
    int n=3;
    char arr[][];
    Status status;
    int LastType;
    public GameManagerService(Player[] players){
        this.players=new HashMap<Character,Player>();
        for(int i=0;i<2;i++){
            this.players.put(players[i].getType(),players[i]);
        }
        LastType='o';
        status=Status.ONGOING;
        arr=new char[n][n];
        Arrays.stream(arr).forEach(a->Arrays.fill(a, '_'));
    }
    public void printboard() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void nextmove(char type,String x,String y) throws IllegalPlayerException {
        if(LastType==type){
            throw new IllegalPlayerException();
        }
        LastType=type;
        int xpos=Integer.parseInt(x);
        int ypos=Integer.parseInt(y);

        arr[xpos][ypos]=type;
        boolean win=true;
        //check horizontal
        for(int i=0;i<n-1;i++){
            if(arr[xpos][i]!=arr[xpos][i+1]) {
                win = false;
            break;
            }
        }
        if(setStatus(win,type))
        return;

        win=true;
        //check vertical
        for(int i=0;i<n-1;i++){
            if(arr[i][ypos]!=arr[i+1][ypos]){
                win = false;
                break;
            }
        }
        if(setStatus(win,type))
        return;


        //check left diagonal
        if(xpos==ypos) {
            win=true;
        for(int i=0;i<n;i++){
            if(i+1<n)
                if (arr[i][i] != arr[i+1][i+1]){
                    win = false;
                    break;
                }
            }
        }
        if(setStatus(win,type))
        return;


        //check right diagonal
        if(xpos+ypos==n-1) {
            win=true;
            for(int i=0;i<n;i++){
                if (arr[i][n-i-1] != arr[i+1][n-i-2]){
                    win = false;
                    break;
                }
            }
        }
        if(setStatus(win,type))
        return;

    }
    public boolean setStatus(boolean win,char type){
        if(win==true) {
            if (type == 'x') {
                status = Status.XWIN;
            } else if (type == 'o') {
                status = Status.OWIN;
            }
        }
            return win;
    }
    public Status getStatus() {
        return status;
    }
}
