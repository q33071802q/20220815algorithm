package datastruct.queue;

import datastruct.list.MyLinkedList;

public class MyLinkedQueue<T> implements MyQueue<T> {

    Node firstNode;
    Node lastNode;
    int size = 0;

    class Node {
        Node nextNode = null;
        T data;

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node(T t) {
            this.data = t;
        }
    }

    @Override
    public void add(T t) throws Exception {
        Node node = new Node(t);
        if (size == 0) {
            firstNode = node;
            lastNode = node;
        } else {
            lastNode.nextNode = node;
            lastNode = node;
        }
        size++;
    }

    @Override
    public T offer() {
        T data = firstNode.getData();
        firstNode = firstNode.nextNode;
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) throws Exception {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        for (int i = 0; i < 8; i++) {
            queue.add(i);
        }

        for (int i = 0; i < 8; i++) {
            System.out.println(queue.offer());
            System.out.println(queue.isEmpty());
        }
    }
}
