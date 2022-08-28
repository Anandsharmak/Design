package controller;
import handler.TopicHandler;
import model.Subscriber;
import model.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

public class Queue {

    HashMap<String,TopicHandler> topicList;
    ExecutorService es;
    public Queue(ExecutorService es){
        topicList=new HashMap<>();
        this.es=es;
    }

    public Topic addTopic(String t1) {
    Topic topic=new Topic(t1, UUID.randomUUID().toString(),new ArrayList<>());
    TopicHandler th=new TopicHandler(topic,new ArrayList<>(),es);
        topicList.put(t1,th);
        return topic;
    }

    public void subscribe(Subscriber s1, Topic t1){
        TopicHandler th= topicList.get(t1.getName());
        th.registerSubscriber(s1);
    }

    public void publishMessage(Topic t1,String m1) {
        System.out.println(t1.getName()+" is publishing "+m1);
        TopicHandler th = topicList.get(t1.getName());
        th.addMessage(m1);
        th.notifySubscriber();
    }
}
