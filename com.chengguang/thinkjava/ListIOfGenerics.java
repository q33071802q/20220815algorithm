package thinkjava;

import java.util.ArrayList;
import java.util.List;

public class ListIOfGenerics<T> {
    private List<T> array = new ArrayList<>();
    public void add(T item){
        array.add(item);
    }
    public T get(int index){
        return array.get(index);
    }
}
