package model;

import handler.SubscriberHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
@AllArgsConstructor
@Getter
public class SubscriberWorker {
    AtomicInteger offset=new AtomicInteger(0);
    Subscriber subscriber;
}
