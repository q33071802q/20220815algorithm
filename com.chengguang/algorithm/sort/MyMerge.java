package algorithm.sort;

import java.util.Arrays;

import static algorithm.sort.Sort.less;
import static algorithm.sort.Sort.show;

public class MyMerge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 思路  先归并微型数组，再成对归并得到的子数组。
     *
     * @param a
     */
    public static void bottomUpSort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {  //sz 是子数组的大小
            int i = 0;
            for (int lo = 0; lo < N - sz; lo += sz + sz) {  //lo子数组的索引
                i++;
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
            System.out.println("循环次数：" + i);
        }
    }

    public static void main(String[] args) {
//        String[] a = new In("tiny.txt").readAllStrings();
//        bottomUpSort(a);
//        sort(a);
        MaxPQ<String> stringMaxPQ = new MaxPQ<>(9);
        stringMaxPQ.insert("a");
        stringMaxPQ.insert("c");
        stringMaxPQ.insert("b");

//        show(stringMaxPQ);
    }

    /**
     * 递归 属于自顶向下
     *
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }




    /**
     * 归并排序 将两个有序的数组 归并成一个更大的有序数组
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = 0; k < a.length; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }

        }

    }
}
