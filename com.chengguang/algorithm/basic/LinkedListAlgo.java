package algorithm.basic;

/**
 * 1.单链表反转 1
 * 2。链表中环的检测 1
 * 3。两个有序的链表合并 1
 * 4。删除链表倒数第n个结点 1
 * 5。求链表的中间结点 1
 */
public class LinkedListAlgo {

    /**
     * 反转链表
     *
     * @param list
     * @return
     */
    public static Node reverse(Node list) {
        Node curr = list;
        Node pre = null;
        while (curr!=null){
            Node temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    /**
     * 链表中环的检测
     */
    public static boolean checkCircle(Node list) {
        if (list == null) return false;

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }
        return false;
    }


    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 两个有序的链表合并
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return soldier.next;
    }

    /**
     * 删除链表倒数第k个结点
     *
     * 定义两个指针 一个快的 一个慢的 快的先移动n步 慢的才开始跟快的一起移动
     * 当快的结束的时候
     * 慢的那个就指向了要删除的结点
     */
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k+1) {
            fast = fast.next;
            i++;
        }

        //判断k在范围外 直接返回结点
        if (fast == null) return list;

        //获取第k个结点
        Node slow = list;
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return list;
    }

    /**
     * 求链表的中间结点
     */
    public static Node findMiddleNode(Node list){
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        while (slow.next!=null&&fast.next.next!=null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node createNewNode(int val){
        return new Node(val,null);
    }

    public static void printAll(Node list){
        while (list!=null){
            System.out.print(list.data+" ");
            list = list.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }


    public static class Test{
        public static void main(String[] args) {
            Node head = createNewNode(1);
            for (int i = 2; i < 10; i++) {
                Node p = head;
                while (p.next!=null){
                    p = p.next;
                }
                p.next = createNewNode(i);
            }
            printAll(head);

            Node pre = reverse(head);
            printAll(pre);

            deleteLastKth(pre,2);
            printAll(pre);

            System.out.println(checkCircle(pre));

        }
    }
}
