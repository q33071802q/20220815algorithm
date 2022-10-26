package design.observer.demo.fetch;

import java.util.ArrayList;
import java.util.List;

/**
 * 拉模型
 */
public abstract class Subject {
    private List<Observer> list = new ArrayList<>();

    public void attach(Observer observer){
        list.add(observer);
        System.out.println("Attach an observer");
    }

    public void detach(Observer observer){
        list.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : list) {
            observer.update(this);
        }
    }
}
