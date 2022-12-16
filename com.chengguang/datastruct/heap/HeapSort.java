package datastruct.heap;

/**
 * 发明堆排序的人 真是神人 罗伯特·弗洛伊德 希望我能赶上他十分之一成就吧
 *
 * 行了 堆就到这里吧
 */
public class HeapSort {
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        buildHead(arr);

        /**
         * 排序是一件很自然的事 因为堆顶一定是最大值
         * 所以只需要每次将堆顶的元素与最后一个元素进行交换位置
         * 然后将除去堆顶的那个元素之外的元素堆重新堆化 那么全部执行完
         * 数组中的元素必然就是从小到大了
         */
        int k = arr.length - 1;
        while (k > 0) {
            swap(arr, 0, k);
            heapify(arr, --k, 0);
        }
    }

    /**
     * 建堆
     *
     * @param arr
     */
    private static void buildHead(int[] arr) {
        //arr.length-1 为最后一个叶子节点的父节点
        //就是说从最后一个非叶子节点 以此堆化直到根节点
        /**
         * 这里每次循环内部都是一个while(true) 退出条件是maxpos = i
         * 意思是直到该非叶子节点全部节点都是按堆大小排好序的了
         * 才会去i-- 给下一个非叶子节点堆化 直到i=0 意思每个叶子节点都堆化完成
         */
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, arr.length - 1, i);
        }
    }

    /**
     * 堆化 从上往下
     * 选择父节点下左右子树的最大值替换当前父节点的值
     * 然后将索引i移动到被替换的索引位置
     *
     * @param arr 要堆化的数组
     * @param n   最后堆元素下标
     * @param i   要堆化的元素下标
     */
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i*2+1;
            }
            if (i*2+2<=n&&arr[maxPos]<arr[i*2+2]){
                maxPos = i*2+2;
            }
            if (maxPos==i){
                return;
            }
            swap(arr,i,maxPos);
            //继续往下寻找
            i = maxPos;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
