package algorithm.sort;


public class Solution_19 {

    static String[] strs = {"You", "are", "a", "good", "boy"};

    private class Node {
        String item;
        Node next;
    }

    public static void main(String[] args) {
        Node first = creatList(strs);
        System.out.println("删除最后一个节点之前链表为：");
        printList(first); //打印原始链表
//        deleteLastNode(first);
       getNode(2);
//        printList(first); //打印原始链表
    }

    public static void getNode(int k) {
        Node first = creatList(strs);
        //先遍历找到第k个元素
        int i = 0;
        for (; first.next != null; first = first.next,i++) {
            if (i==k-1){
                first = first.next;
                first.next = first.next.next;
                break;
            }
        }
        printList(first);
    }

    private static void deleteLastNode(Node first) {
        if (first.next == null) {
            first = null;
        } else {
            Node current = first;
            Node secondLast = first;
            while (current.next != null) {
                secondLast = current;
                current = current.next;
            }
            secondLast.next = null;
        }
    }

    private static void printList(Node first) {
        System.out.println(first.item);//打印头节点
        Node current = first;
        while (current.next != null) {
            current = current.next;
            System.out.println(current.item);
        }
    }

    public static Node creatList(String[] strs) {

        Solution_19 solution = new Solution_19();
        Node newnode = solution.new Node();
        newnode.item = strs[0];
        Node first = newnode;


        Node current = first;
        for (int i = 1; i < strs.length; i++) {
            newnode = solution.new Node();
            newnode.item = strs[i];
            current.next = newnode;
            current = newnode;
        }
        current.next = null;//尾节点指针指向null
        return first;
    }

}
