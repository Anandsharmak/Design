package model;

public interface ISubject {
   void registerSubscriber(Subscriber subscriber);
   void unRegisterSubscriber(Subscriber subscriber);
   void notifySubscriber();
}
