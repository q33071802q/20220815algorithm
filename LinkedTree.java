package algorithm.data;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class LinkedTree {
    class Node {
        Node left = null;
        Node rigth = null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    Node firstNode = null;
    int size = 0;
    int capacity = 0;
    Queue queue = null;

    public void add(int i) {
        Node node = (Node) queue.peek();

        if (node.left == null) {
            Node left = new Node(i);
            node.left = left;
            queue.add(left);
            size++;
            return;
        }

        if (node.rigth == null) {
            Node rigth = new Node(i);
            node.rigth = rigth;
            queue.add(rigth);
            size++;
            return;
        }

        queue.poll();
    }

    public LinkedTree(int capacity, int[] arr) {
        this.capacity = capacity;
        queue = new ArrayBlockingQueue(capacity);

        Node firstNode = new Node(arr[0]);
        this.firstNode = firstNode;
        queue.add(firstNode);

        int i = 1;
        while (!queue.isEmpty()) {

            Node node = (Node) queue.peek();

            if (i < arr.length && node.left == null) {
                Node left = new Node(arr[i++]);
                node.left = left;
                queue.add(left);
            } else {
                break;
            }

            if (i < arr.length && node.rigth == null) {
                Node right = new Node(arr[i++]);
                node.rigth = right;
                queue.add(right);
            } else {
                break;
            }

            queue.poll();
        }
    }

    public void preOrderPrint(Node node) {
        //self
        System.out.println(node.data);

        //left child
        if (node.left != null) {
            preOrderPrint(node.left);
        }

        //right child
        if (node.rigth!=null){
            preOrderPrint(node.rigth);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 7, 5, 8, 8};
        LinkedTree linkedTree = new LinkedTree(10, arr);
        linkedTree.preOrderPrint(linkedTree.firstNode);
    }
}
