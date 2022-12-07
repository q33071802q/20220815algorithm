package datastruct.queue;

import datastruct.list.MyArrayList;

public class MyArrayQueue<T> implements MyQueue<T> {
    /**
     * 首索引 用于出队
     */
    int firstIndex = 0;
    /**
     * 尾索引 用于入队
     */
    int lastIndex = 0;
    int size = 0;
    int maxSize = 0;
    T[] arr;

    public MyArrayQueue(int size) {
        arr = (T[]) new Object[size];
        this.maxSize = size;
    }

    @Override
    public void add(T t) throws Exception {
        if (size == maxSize) {
            throw new Exception("队列已满");
        }

        if (lastIndex < maxSize) {
            arr[lastIndex] = t;
        } else {
            arr[(lastIndex + 1) % maxSize] = t;
        }
        lastIndex = (lastIndex + 1) % maxSize;
        size++;
    }

    @Override
    public T offer() {
        T buff = arr[firstIndex];
        firstIndex = (this.firstIndex + 1) % maxSize;
        size--;
        return buff;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) throws Exception {
        MyArrayQueue<Integer> myQueue = new MyArrayQueue<>(11);
        for (int i = 0; i < 11; i++) {
            myQueue.add(i);
        }
        for (int i = 0; i < 7; i++) {
            System.out.println(myQueue.offer());
        }
    }
}
