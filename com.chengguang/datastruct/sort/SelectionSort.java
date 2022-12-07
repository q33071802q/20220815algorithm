package datastruct.sort;

import java.util.Arrays;

/**
 * 与插入排序的逻辑类似 都是将数据分为已排序和未排序区
 * 区别在于 选择排序每次都会从未排序区间中找到最小的元素 放到已排序的区间末尾
 * 而插入排序 是在未排序区间将每个遍历到的元素放到已排序的区间 不管这个元素是否为未排序区间中的最小值
 */
public class SelectionSort {

    public void selectionSort(int[] arr, int l, int r) {
        for (int i = l; i < r; i++) {
            int minIndex = i;
            //寻找未排序区域中最小的元素位置 然后将当前索引位置元素进行交换
            for (int j = i + 1; j < r; j++) {
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] origin = {4, 5, 6, 1, 2, 3};
        new SelectionSort().selectionSort(origin, 0, 6);
        System.out.println(Arrays.toString(origin));
    }


}
