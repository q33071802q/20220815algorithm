package design.observer.demo.push;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主题 推模型
 */
public abstract class Subject {
    /**
     * 主题持有的观察者集合
     */
    private List<Observer> list = new ArrayList<>();

    /**
     * 新增观察者
     * @param observer
     */
    public void attach(Observer observer){
        list.add(observer);
        System.out.println("attached an observer");
    }

    /**
     * 丢弃观察者
     * @param observer
     */
    public void detach(Observer observer){
        list.remove(observer);
    }

    /**
     * 通知所有观察者
     * @param newState
     */
    public void notifyObservers(String newState){
        for (Observer observer : list) {
            observer.update(newState);
        }
    }
}
