package leetcode.array.top200;

/**
 * 将两个链表相加 总数按一个返回
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode listNodePos = listNode;
        boolean addOne = false;
        while (l1 != null || l2 != null || addOne) {
            int num1 = 0, num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }

            int sum = num1 + num2;
            if (addOne) sum++;
            addOne = false;
            if (sum > 9) {
                addOne = true;
                sum = sum - 10;
            }

            ListNode resultList = new ListNode(sum);
            listNodePos.next = resultList;
            listNodePos = listNodePos.next;
        }
        return listNode.next;
    }

    /**
     * 将结果直接存入l1中
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode ans = l1;
        ListNode temp = null;
        int addOne = 0;

        while (l1 != null) {
            if (l2 != null) {
                l1.val = l1.val + l2.val + addOne;
                addOne = 0;
                if (l1.val > 9) {
                    l1.val -= 10;
                    addOne = 1;
                }
                temp = l1;
                l1 = l2.next;
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            temp.next = l2;
        }

        l1 = temp.next;
        while (l1 != null || addOne!=0) {
            l1.val++;
            addOne = 0;
            if (l1.val>9){
                l1.val-=10;
                addOne = 1;
            }
            temp = l1;
            l1 = l1.next;
        }
        if (addOne == 0){
            temp.next = new ListNode(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode listNode = getListNode();
//        while (listNode!=null){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }

        ListNode listNode2 = getListNode2();
//        while (listNode2!=null){
//            System.out.println(listNode2.val);
//            listNode2 = listNode2.next;
//        }

        ListNode listNode1 = addTwoNumbers(listNode, listNode2);

        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }

    }

    private static ListNode getListNode2() {
        ListNode listNode = new ListNode(5);
        ListNode node = new ListNode(6);
        ListNode listNode1 = new ListNode(4);
        ListNode start = listNode;
        start.next = node;
        start = start.next;
        start.next = listNode1;
        return listNode;
    }

    private static ListNode getListNode() {
        ListNode listNode = new ListNode(2);
        ListNode node = new ListNode(4);
        ListNode listNode1 = new ListNode(3);
        ListNode start = listNode;
        start.next = node;
        start = start.next;
        start.next = listNode1;
        return listNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
