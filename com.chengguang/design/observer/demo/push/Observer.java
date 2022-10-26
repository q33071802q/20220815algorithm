package design.observer.demo.push;

/**
 * 抽象观察者
 */
public interface Observer {
    /**
     * 更新状态
     * @param state
     */
    public void update(String state);
}
