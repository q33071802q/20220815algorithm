package datastruct.stack;

public class MyArrayStack<T> implements MyStack<T> {
    int index = 0;
    int size;
    T[] arr;
    public MyArrayStack(int size){
        arr = (T[])new Object[size];
        this.size = size;
    }
    @Override
    public void push(T t) {
        arr[index] = t;
        index++;
    }

    @Override
    public T pop() {
        index--;
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        return index==0;
    }

    public static void main(String[] args) {
        MyArrayStack<Integer> myStack = new MyArrayStack<>(10);
        for (int i = 0; i < 10; i++) {
            myStack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(myStack.pop());
        }
    }
}
