package datastruct.stack;

public class MyLinkedStack<T> implements MyStack<T> {
    Node firstNode = null;
    Node lastNode = null;
    int size = 0;

    class Node{
        Node nextNode;
        T data;
        public void setData(T data){
            this.data = data;
        }
        public T getData(){
            return data;
        }
        public Node(T data){
            this.data = data;
        }
    }

    @Override
    public void push(T t) {
        Node node = new Node(t);
        if (size==0){
            firstNode = node;
            lastNode = node;
        }else {
            lastNode.nextNode = node;
            lastNode = node;
        }
        size++;
    }

    @Override
    public T pop() {
        T data = firstNode.getData();
        firstNode = firstNode.nextNode;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) {
        MyLinkedStack<Integer> myStack = new MyLinkedStack<>();
        for (int i = 0; i < 10; i++) {
            myStack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(myStack.pop());
        }
    }
}
