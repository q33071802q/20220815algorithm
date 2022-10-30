package datastruct.list;

import algorithm.sort.In;

public class MyArrayList<T> implements MyList<T> {
    /**
     * 数组当前长度
     */
    private int length = 0;
    /**
     * 数组最大值
     */
    private int max = 10;
    private T[] arr;

    public MyArrayList() {
        this.arr = (T[]) new Object[this.length];
    }

    @Override
    public void add(T o) {
        if (length < this.max - 1) {
            //创建一个新的长度数组 然后把数据塞进去
            this.max = 2 * this.max;
            T[] buff = arr;
            arr = (T[]) new Object[this.max];
            for (int i = 0; i < buff.length; i++) {
                arr[i] = buff[i];
            }
        }
        arr[length] = o;
        length++;
    }

    @Override
    public T get(int index) {
        return arr[index];
    }

    @Override
    public T remove(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("索引不存在");
        }
        if (index > this.length) {
            throw new Exception("索引已不在数组中");
        }
        //删除index对应的 然后copy index后面的数据到当前数据
        T removed = arr[index];
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        this.length--;
        return removed;
    }

    @Override
    public void print() {
        for (T t : arr) {
            System.out.print(t + ",");
        }
    }

    @Override
    public T update(int index, T o) {
        T updated = arr[index];
        arr[index] = o;
        return updated;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length==0;
    }

    public static void main(String[] args) throws Exception {
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println(list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        list.update(1,5);
        System.out.println(list.length);
        System.out.println(list.isEmpty());
        list.print();

    }
}
