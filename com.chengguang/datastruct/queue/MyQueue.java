package datastruct.queue;

public interface MyQueue<T> {
    void add(T t) throws Exception;

    T offer();

    boolean isEmpty();
}
