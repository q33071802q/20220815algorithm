package leetcode.array.remove;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,return an array of the
 * squares of each number sorted in non-decreasing order.
 * <p>
 * 分析
 * 给数组中的每个数平方，然后从小到大排序输出
 * <p>
 * 直接做不就完了 有啥难度 来个快排吧 先分区 然后对区内的数据进行递归再分区 直到只剩单独的一个
 * <p>
 * 妈的 居然是垫底的5% 我这个时间复杂度太高了 O（n^2） 试试快排吧 但是我忘了咋写 跟归并排序差不多 但是分区之后不需要合并再排序
 * 相当于每次选择的基数都在自己的位置
 */
public class SquaresOfSortArray {
    public int[] sortedSquares(int[] nums) {
        initArr(nums);
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = i; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums,i,high);
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void qsort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = partition(nums, low, high);
            qsort(nums, low, mid - 1);
            qsort(nums, mid + 1, high);
        }
    }

    private static void initArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
    }

    private static void bubooleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        SquaresOfSortArray squaresOfSortArray = new SquaresOfSortArray();
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(squaresOfSortArray.sortedSquares(nums)));
    }
}
