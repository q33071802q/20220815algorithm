package datastruct.heap;

public class Heap {
    private int[] a; //数组 从下标1开始存储数据
    private int n; // 堆可以存放的最大数据个数
    private int count;//堆中已经存放的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) {
            return;
        }
        count++;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { //从下向上堆化
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 哦 移动最后一个元素 一定不会出现数组空洞 这样就不会造成处理完不是完全二叉树的问题了
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

//    /**
//     * 向下堆化这个过程能理解 理解了 就是从根节点往下弄
//     *
//     * @param a
//     * @param n
//     * @param i
//     */
//    private void heapify(int[] a, int n, int i) {
//        while (true) {
//            int maxPos = i;
//            if (i * 2 <= n && a[i] < a[i * 2]) { //有左子树且父节点小于左子树
//                maxPos = i * 2;
//            }
//            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
//                //有右子树且左子树的最小值比右子树还要小
//                maxPos = i * 2 + 1;
//            }
//            if (maxPos == i) break;
//            swap(a, i, maxPos);
//            i = maxPos;
//        }
//    }

    public void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    public void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public void swap(int[] arr, int a1, int a2) {
        int temp = arr[a1];
        arr[a1] = arr[a2];
        arr[a2] = temp;
    }

    /**
     * 太牛逼了 就算现在写出来了 我依旧觉得有点像魔法
     *
     * @param a
     * @param n
     */
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a,1,k);
            --k;
            heapify(a,k,1);
        }
    }
}
