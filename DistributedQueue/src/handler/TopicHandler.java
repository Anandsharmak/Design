package handler;

import lombok.AllArgsConstructor;
import model.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class TopicHandler implements ISubject {

    Topic topic;
    List<SubscriberHandler> subscriberList;
    ExecutorService es;
    public void addMessage(String message){
        topic.getMessages().add(message);
    }


    @Override
    public void registerSubscriber(Subscriber subscriber) {
        SubscriberHandler sh=new SubscriberHandler(topic,new SubscriberWorker(new AtomicInteger(0),subscriber));
        subscriberList.add(sh);
        new Thread(sh).start();
    }

    @Override
    public void unRegisterSubscriber(Subscriber subscriber) {
//        SubscriberHandler sh=new SubscriberHandler(topic,subscriber,new0);
//        subscriberList.remove(sh);
    }

    @Override
    public void notifySubscriber() {
        subscriberList.forEach(
                SubscriberHandler::wakeUpIfNeeded
        );
    }
}
