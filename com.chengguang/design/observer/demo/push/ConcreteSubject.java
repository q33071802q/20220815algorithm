package design.observer.demo.push;

/**
 * 具体的主题
 */
public class ConcreteSubject extends Subject {
    private String state;

    public String getState() {
        return state;
    }

    public void change(String newState){
        state = newState;
        System.out.println("主题状态为："+state);
        this.notifyObservers(newState);
    }

}
