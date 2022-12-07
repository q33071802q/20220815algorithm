package datastruct.search;

/**
 * 二分查找
 * 1000W整数数据 每个8字节 设计数据结构算法 快速判断某个整数
 * 是否出现在这1000W数据 内存不要超过100M
 * 针对的是有序的数据集合
 */
public class BinarySearch {
    public int bsearch(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


}

