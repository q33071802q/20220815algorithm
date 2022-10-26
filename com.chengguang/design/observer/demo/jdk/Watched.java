package design.observer.demo.jdk;

import java.util.Observable;

/**
 * 被观察者
 */
public class Watched extends Observable {
    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!this.data.equals(data)) {
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }

}
