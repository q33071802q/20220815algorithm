package leetcode.array.search;

/**
 * leetcode 704 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * given an array of integers nums which is sorted in ascending order,
 * and an integer target,write a function to search target in nums.
 * if target exists,then return its index.Otherwise,return -1.
 * <p>
 * must write an algorithm with O(log n) runtime complexity
 * <p>
 * 分析：
 * 在数组中寻找目标值的索引 很简单 但是时间复杂度必须是O（log n）
 * <p>
 * 思路：
 * 直接循环数组 判断相等 则时间复杂度为O（n）
 * 如何改成O（log n）呢 2^0=1 2^1=2 2^2=4 2^3=8 二分法
 * 因为数组是有序的 所以可以直接比较最中间的数 如果目标数大于数组的中位数 则目标数为中位数的右边 否则在左边
 * 1.获取数组中位数
 * 2.将target与中位数进行比较
 * 3.大于 在中位数的右边数组中寻找 小于 在中位数的左边数组寻找
 * <p>
 * 数组怎么缩小呢 copy 会增加空间复杂度
 * 能不能在不缩小空间的情况下 从索引范围搜索
 * 怎么限制这个数组的范围呢 是不是可以假设个条件呢
 * 必须知道中位数的值呀。。不然怎么比较
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        return search(0, nums.length - 1, target, nums);
    }

    public int search2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int middle = i + (j - i) / 2;
            if (nums[middle] > target) {
                j = middle-1;
            }else if (nums[middle]<target){
                i = middle+1;
            }else if (nums[middle]==target){
                return middle;
            }
        }
        return -1;
    }

    public int search(int startIndex, int endIndex, int target, int[] nums) {
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        int middle = nums[middleIndex];
        if (target == middle) {
            return middleIndex;
        }
        if (startIndex == endIndex && target != middle) {
            return -1;
        }
        if (target > middle) {
            return search(middleIndex + 1, endIndex, target, nums);
        } else if (target < middle) {
            return search(startIndex, middleIndex, target, nums);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{5};
        BinarySearch binarySearch = new BinarySearch();
//        System.out.println(binarySearch.search(testArray, 13));
        System.out.println(binarySearch.search2(testArray, 5));
    }
}
