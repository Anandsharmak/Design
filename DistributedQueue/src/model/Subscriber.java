package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Subscriber implements Isubscriber{

    String name;
    public Subscriber(String name){
        this.name=name;
    }
    @Override
    public void consumeMessage(String message) {
        System.out.println(name+" is consuming "+message);
    }
}
