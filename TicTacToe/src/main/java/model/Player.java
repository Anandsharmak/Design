package model;

public class Player {
    String name;
    char type;
    public Player(String name,char type){
        this.name=name;
        this.type=type;
    }
    public char getType(){
        return type;
    }

}
