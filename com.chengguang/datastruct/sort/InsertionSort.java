package datastruct.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 向有序的集合中插入数据 只要遍历到应该插入的位置然后将其插入即可
 * 思想 取未排序区间的元素 在已排序区间中找到合适的插入位置将其插入 并保证排序区始终有序
 * 直到未排序区间元素为空，结束算法。
 * <p>
 * 懂了思想 自己写呗 为啥一定要理解别人的代码
 * <p>
 * 先找插入的位置 找到之后 将该位置的数都往后移一位 最后将数放到空出来的位置
 */
public class InsertionSort {
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            // i 代表索引位置 将前面的排序
            for (int j = i + 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    a[j++] = a[j];
                }
            }
        }
    }

    /**
     * 存在交换多次的情况
     *
     * @param arr
     * @param l
     * @param r
     */
    public void insertionSort2(int[] arr, int l, int r) {
        for (int i = l; i < r; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public void insertionSort4(int[] arr, int l, int r) {
        for (int i = l; i < r; i++) {
            int buff = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > buff) {
                arr[j] = arr[j - 1];
                j--;
            }
            //这里的j会移动到最小的位置上 通过上面的while循环比较改变j的大小
            arr[j] = buff;
        }
    }

    public void insertionSort3(int[] arr, int l, int r) {
        for (int i = l; i < r; i++) {
            int buff = arr[i];//保存当前值
            int j = i;
            //维护前面已经排好序的数组
            while (j > 0 && arr[j - 1] > buff) {//如果前面的数比当前的buff大
                arr[j] = arr[j - 1];//将前面的数赋值给后面
                j--;
            }
            arr[j] = buff;
        }
    }

    public static void main(String[] args) {
        int[] origin = {4, 5, 6, 1, 2, 3};
        new InsertionSort().insertionSort3(origin, 0, 6);
        System.out.println(Arrays.toString(origin));
        int[] ints = {263970, 144883, 136525, 112670, 60372, 46187, 43355, 39882, 32750, 22235, 21439, 16485, 8655, 6123, 5884, 5782, 5424, 3968, 3657, 3421, 2473, 893, 1};
        System.out.println(Arrays.stream(ints).summaryStatistics().getSum());
    }
}
