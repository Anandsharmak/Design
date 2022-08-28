package handler;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import model.SubscriberWorker;
import model.Topic;

@AllArgsConstructor
public class SubscriberHandler implements Runnable {

    Topic topic;
    final SubscriberWorker subscriberWorker;

    @SneakyThrows
    @Override
    public void run() {
        synchronized (subscriberWorker) {
            do {

                while (topic.getMessages().size() <= subscriberWorker.getOffset().get()) {
                    subscriberWorker.wait();
                }
                subscriberWorker.getSubscriber().consumeMessage(topic.getMessages().get(subscriberWorker.getOffset().get()));
                subscriberWorker.getOffset().set(subscriberWorker.getOffset().get()+1);
                Thread.sleep(1000);
            }while (true);
        }
    }
    synchronized public void wakeUpIfNeeded() {
        synchronized (subscriberWorker) {
            subscriberWorker.notify();
        }
    }
}
