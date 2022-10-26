package design.observer.demo.fetch;

import design.observer.demo.fetch.Subject;

/**
 * 拉模型
 */
public interface Observer {

    public void update(Subject subject);
}
