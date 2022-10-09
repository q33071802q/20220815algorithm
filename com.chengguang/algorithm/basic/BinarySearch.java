package algorithm.basic;

import algorithm.sort.In;
import algorithm.sort.StdIn;
import algorithm.sort.StdOut;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {
        //数组必须是有序的
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = new In("sort.txt").readAllInts();
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            //读取键值，如果不存在于白名单直接打印
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
        System.out.println(Arrays.toString(whitelist));
    }

}
