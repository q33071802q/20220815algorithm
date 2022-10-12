package algorithm.basic;

import algorithm.sort.In;
import algorithm.sort.StdIn;
import algorithm.sort.StdOut;

import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {
    /**
     * 在一个整数数组中找到一个数
     *
     * @param key
     * @param a
     * @return
     */
    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;

        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            int guessKey = a[mid];
            if (guessKey == key) {
                return mid;
            } else if (guessKey > key) {
                high = mid - 1;
            } else if (guessKey < key) {
                low = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] whitelist = new int[]{2,4,3,1,0};
        Arrays.sort(whitelist);
        System.out.println("在数组中的index位置："+rank(3, whitelist));
    }

}
