package datastruct.sort;

/**
 * 计数排序
 * 计数 基数 先跳过 有点晕
 */
public class CountingSort {

    public static void countingSort(int[] arr, int n) {
        if (n <= 1) return;

        //获取数组中数据的范围
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int[] c = new int[max + 1];


    }
}
