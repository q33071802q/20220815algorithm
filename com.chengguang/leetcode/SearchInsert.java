package leetcode;

/**
 * Given a sorted array of distinct integers and a target value,return the index if the target is found.
 * if not,return the index where it would be if it were inserted in order
 * <p>
 * you must write an algorithm write O(log n) runtime complexity
 * <p>
 * 插入排序 如果target在数组中存在 则返回target在目标数组中的索引 如果不存在 则将target插入数组后 返回插入的位置
 * <p>
 * 又是要求O（log n）的时间复杂度 只有二分法能满足这个时间复杂度
 * 思路
 * 二分法找到要插入的位置
 * 1.递归获取索引位置
 * 2.判断是否存在
 * 存在 返回该位置的索引
 * 不存在 获得比target的上一个位置 初始化一个新数组 将该索引后面的数组拷贝一份到新数组 然后将target插入到索引的位置 并返回索引位置
 * <p>
 * 有一个问题 如果没有找到 怎么办
 *
 * 怎么获得target的上一个位置
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int middle = i + (j - i) / 2;
            if (target > nums[middle]) {
                i = middle+1;
            } else if (target < nums[middle]) {
                j = middle - 1;
            }else if (target == nums[middle]){
                return middle;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{1,3,5,6};
        SearchInsert searchInsert = new SearchInsert();
//        System.out.println(binarySearch.search(testArray, 13));
        System.out.println(searchInsert.searchInsert(testArray,2));
    }


}
