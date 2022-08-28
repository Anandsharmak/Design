import controller.Queue;
import lombok.SneakyThrows;
import model.Subscriber;
import model.Topic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String args[]){
        ExecutorService es = Executors.newWorkStealingPool();
        es.shutdown();

        Queue queue=new Queue(es);
        Topic t1=queue.addTopic("t1");
        Topic t2=queue.addTopic("t2");
        queue.addTopic("t2");
        Subscriber s1=new Subscriber("s1");
        Subscriber s2=new Subscriber("s2");
        queue.subscribe(s1,t1);
        queue.subscribe(s2,t2);
        Thread.sleep(2000);
        queue.publishMessage(t1,"m1");// s1,m1
        Thread.sleep(2000);
        queue.publishMessage(t2,"m2");// s2,m2
        Subscriber s3=new Subscriber("s3");

        queue.subscribe(s3,t1);// s3,m1
        queue.subscribe(s3,t2);// s3,m2
        Thread.sleep(2000);
        queue.publishMessage(t2,"m3");//s2,m3 s3,m3

        boolean finished = es.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Code Execution finished");
    }
}
