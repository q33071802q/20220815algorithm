package datastruct.list;

public interface MyList<T> {
    void add(T o);

    T get(int index);

    T remove(int index) throws Exception;

    void print();

    T update(int index,T o);

    int size();

    boolean isEmpty();
}
