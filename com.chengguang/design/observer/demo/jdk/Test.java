package design.observer.demo.jdk;


import java.util.Observer;

public class Test {
    public static void main(String[] args) {
        Watched watched = new Watched();
        Observer watcher = new Watcher(watched);
        watched.setData("start");
        watched.setData("run");
        watched.setData("stop");
    }
}
