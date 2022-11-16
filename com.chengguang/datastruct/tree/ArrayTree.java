package datastruct.tree;

/**
 * 1.满二叉树数组实现
 * 2.树的前中后序遍历
 * +1代表左 +2代表右
 */
public class ArrayTree {
    private int[] arr = null;
    /**
     * 当前索引
     */
    private int index = 0;
    /**
     * 总容量
     */
    private int capacity;

    public ArrayTree(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public ArrayTree(int capacity, int[] arr) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }
    }

    public void add(int i) throws Exception {
        if (index > capacity) {
            throw new Exception("树已满");
        }
        arr[index] = i;
        index++;
    }

    /**
     * 前序遍历 深度优先遍历
     *
     * @param index
     */
    public void preOrderPrint(int index) {
        //self
        System.out.println(arr[index]);

        //left child
        if (2 * index + 1 < capacity) {
            preOrderPrint(2 * index + 1);
        }

        //right child
        if (2 * index + 2 < capacity) {
            preOrderPrint(2 * index + 2);
        }
    }

    /**
     * 中序遍历
     *
     * @param index
     */
    public void inOrderPrint(int index) {
        //left child
        if (2 * index + 1 < capacity) {
            inOrderPrint(2 * index + 1);
        }

        //self
        System.out.println(arr[index]);

        //right child
        if (2 * index + 2 < capacity) {
            inOrderPrint(2 * index + 2);
        }
    }

    /**
     * 后序遍历
     * @param index
     */
    public void postOrderPrint(int index) {
        //left child
        if (2 * index + 1 < capacity) {
            postOrderPrint(2 * index + 1);
        }

        if (2 * index + 2 < capacity) {
            postOrderPrint(2 * index + 2);
        }
        System.out.println(arr[index]);
    }

    public static void main(String[] args) {
        int n = 7;
        int[] arr = {9, 4, 2, 7, 5, 8, 8};
        ArrayTree arrayTree = new ArrayTree(n, arr);
//        arrayTree.preOrderPrint(0);
//        arrayTree.inOrderPrint(0);
        arrayTree.postOrderPrint(0);
    }

}
