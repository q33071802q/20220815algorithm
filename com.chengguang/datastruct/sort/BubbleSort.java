package datastruct.sort;

import java.util.Arrays;

public class BubbleSort {
    /**
     * @param a 数组
     * @param n 数组大小
     *          每次比较相邻元素 大的往后排
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {325, 3532, 53, 2, 6, 4423, 92};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
