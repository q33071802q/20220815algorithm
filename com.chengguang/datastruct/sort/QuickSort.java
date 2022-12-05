package datastruct.sort;

import java.util.Arrays;

/**
 * 也是分冶法 不过与归并思路完全不同
 * <p>
 * 快排核心思想：如果要排序数组下标从p到r之间的一组数据
 * 会选择p到r之间的任意一个数据作为pivot
 * 遍历p到r之间的数据
 * 将小于p的放左边 将大于p的放右边 将pivot放中间。
 * 通过递归将区间缩短到1 就说明所有的数据都有序了
 * 用递归公式来表示的话
 * quick_sort(p...r) = quick_sort(p...q-1)+quick_sort(q+1,r)
 * 终止条件 p>=r
 * <p>
 * 原地排序 不借助额外的空间 怎么做到分区
 *
 * 分区和分冶
 */
public class QuickSort {

    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    /**
     * 每次分区的元素q一定在自己应该在的位置上
     * @param arr
     * @param p
     * @param r
     */
    public static void quickSortInternally(int[] arr, int p, int r) {
        if (p >= r) return;

        int q = partition(arr, p, r);
        quickSortInternally(arr, p, q - 1);
        quickSortInternally(arr, q + 1, r);
    }

    /**
     * 分区 就是取两个位置 然后从后面一个位置一直找比分区小的 放到前面
     * 思想 只要找到小的就交换位置 然后把i+1  相当于i之前的元素都是排好序的
     *
     * 相对归并排序来说 好处在于是原地排序 归并排序合并结果集的时候 是需要额外内存空间的
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (arr[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 1, 2, 3};
        new MergeSort2().mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
