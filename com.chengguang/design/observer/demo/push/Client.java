package design.observer.demo.push;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject  = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.attach(observer);
        subject.change("new State");
    }
}
