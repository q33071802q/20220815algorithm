package algorithm.basic;

import algorithm.sort.In;

import java.sql.Array;
import java.util.*;

/**
 * 二分查找 算法图解这本书 可以 我终于入门了 睡觉
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
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = new int[]{2, 4, 3, 1, 0};
        Arrays.sort(whitelist);
        System.out.println("find the number index is " + rank(7, whitelist));
    }

    public static class SelectionSort {
        /**
         * 选择排序的精髓不就在于每次去剩下的数组拿一个最小的么
         *
         * @param arr
         * @return
         */
        public static int[] selectionSort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int small = arr[i];
                    if (arr[j] < small) {
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
            return arr;
        }

        public static void main(String[] args) {
            System.out.println(Arrays.toString(SelectionSort.selectionSort(new int[]{1, 5, 26, 7, 4, 8})));
        }
    }

    public static class QuickSort {
        public static List<Integer> quickSort(List<Integer> items) {
            if (items.size() > 1) {
                List<Integer> smaller = new ArrayList<>();
                List<Integer> same = new ArrayList<>();
                List<Integer> larger = new ArrayList<>();

                Integer chosenItem = items.get(items.size() / 2);
                for (Integer i : items) {
                    if (i < chosenItem) {
                        smaller.add(i);
                    } else if (i > chosenItem) {
                        larger.add(i);
                    } else {
                        same.add(i);
                    }
                }

                quickSort(smaller);
                quickSort(larger);
                //只保留最后一个排好序的结果集
                items.clear();
                items.addAll(smaller);
                items.addAll(same);
                items.addAll(larger);
            }
            return items;
        }

        public static void main(String[] args) {
            List<Integer> integers = new ArrayList<>();
            integers.add(1);
            integers.add(5);
            integers.add(26);
            integers.add(7);
            integers.add(4);
            integers.add(8);
            System.out.println(quickSort(integers));
        }
    }

    public static class MapSort {
        public static void main(String[] args) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("1", 222);
//            long l = System.nanoTime();
            boolean b = map.containsKey("1");
//            long l2 = System.nanoTime();
//            System.out.println(l2-l);
            Integer b2 = map.get("1");
            System.out.println(b2);
//            System.out.println(System.nanoTime()-l2);
        }
    }

    /**
     * 广度优先算法  看算法图解这本书用java完全写不出来 了解下吧算是
     */
    public static class BreadthFirst {
        public static void search(String name) {

        }

        static class Graph{

        }
    }

    /**
     * 最短路径算法
     */
    public static class shortPath{

    }
}
