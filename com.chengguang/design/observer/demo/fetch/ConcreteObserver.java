package design.observer.demo.fetch;

import design.observer.demo.fetch.ConcreteSubject;
import design.observer.demo.fetch.Subject;

public class ConcreteObserver implements Observer{
    private String observerState;

    /**
     * 更新观察者状态
     * @param subject
     */
    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject)subject).getState();
        System.out.println("观察者状态为:"+observerState);
    }
}
