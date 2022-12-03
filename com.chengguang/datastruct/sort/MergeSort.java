package datastruct.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 思想 排序数组 将数组从中间分成前后两部分，然后对前后两部分分别排序，
 * 再将排好序的两部分合并在一起，这样整个数组就有序了
 * 分冶 解决问题的思想 递归 编程技巧
 * 递归实现归并排序
 * <p>
 * 时间复杂度nlogn 空间复杂度 n
 */
public class MergeSort {
    /**
     * @param arr 数组
     * @param n   数组大小
     */
    public void mergeSort(int[] arr, int n) {
        mergeSortInRange(arr, 0, n - 1);
    }

    private void mergeSortInRange(int[] arr, int left, int right) {
        if (left >= right) return;

        int middle = (left + right) / 2;
        mergeSortInRange(arr, left, middle);
        mergeSortInRange(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        //合并数组 先申请一块临时空间 填入要排序的数组
        int[] temp = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            temp[i - l] = arr[i];
        }

        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            System.out.println(Arrays.toString(arr));
            //左边移动完了 把右边的元素全部放进去即可
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            }
            //右边移动完了 直接放入左边的元素即可
            else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            }
            //比较二者的元素大小 放入小的并把对应的位置+1
            else if (arr[i - l] > arr[j - l]) {
                arr[k] = temp[j - l];
                j++;
            } else {
                arr[k] = temp[i - l];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 1, 2, 3};
        new MergeSort().mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

class MergeSort2 {
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = p + (r - p) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);

        merge(a, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            temp[k++] = arr[start++];
        }

        for (i = 0; i <= r - p; ++i) {
            arr[p + i] = temp[i];
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 1, 2, 3};
        new MergeSort2().mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
