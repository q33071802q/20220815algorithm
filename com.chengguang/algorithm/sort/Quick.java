package algorithm.sort;

import java.util.Arrays;

import static algorithm.sort.Merge.exch;
import static algorithm.sort.Merge.less;
import static algorithm.sort.Sort.show;

/**
 * 分冶思想 将一个数组分成两个子数组，将两部分独立的数组排序。
 * 跟归并的区别在于 归并在排序完子数组后，还要继续将两个子数组排序
 * 而快排则在子数组排序完就结束 它是怎么做到的呢？
 * talk is cheap ,show me code
 */
public class Quick {
    public static void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
//        System.out.printf("我递归执行了？%s_%s\n", lo, j);
        System.out.printf("我的排序结果%s\n",Arrays.toString(a));
        sort(a, lo, j - 1);
//        System.out.println("我执行了吗");
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
//        System.out.printf("我partition执行了？%s_%s\n",lo,hi);
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
//        System.out.println(Arrays.toString(a));
        exch(a, lo, j);
//        System.out.printf("我partition每次执行返回的结果？%s对应的字符:%s\n",j,a[j]);
        return j;
    }

    public static void main(String[] args) {
        String[] a = new In("tiny.txt").readAllStrings();
        sort(a);
        show(a);
    }
}
