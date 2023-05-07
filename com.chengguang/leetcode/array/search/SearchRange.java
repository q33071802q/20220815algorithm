package leetcode.array.search;

import java.util.Arrays;

/**
 * find first and last position of element in sorted array.
 * <p>
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * if target is not found in the array,return [-1,-1]
 * algorithm O(log n) runtime complexity
 * <p>
 * 分析 O(log n)时间复杂度 只能是二分
 * 需要找到符合的 第一个和最后一个 first last position
 * <p>
 * 思路 将数组分割成左右两边
 * 1.二分查找左边的
 * 2.二分查找右边的
 * 3.将1 2 结果合并
 * <p>
 * 如果都在右边怎么办 再次切割 直到数组为1的长度 分冶法 返回各自的索引 返回一个数组
 * <p>
 * 我知道了 用一个数组 引用索引位置和索引存储的值
 * <p>
 * 这个问题其实是 如果只有一个命中了 那数组结果均为命中的那个就万事了
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result2[i] = 0;
        }

        searchRange(nums, 0, nums.length - 1, target, result2);

        //遍历数组 将1的索引位置打印出来
        int[] result = {-1, -1};
        int j = 0;
        //寻找最小索引 和最大索引
        for (int i = 0; i < result2.length; i++) {
            if (result2[i] == 1){
                j++;
            }
        }
        int[] index = new int[j];
        j=0;
        for (int i = 0; i < result2.length; i++) {
            if (result2[i] == 1){
                index[j++] = i;
            }
        }

        //取头尾 头就是最小的 尾是最小的
        if (index.length==0){
            return result;
        }else if (index.length==1){
            result[0] = index[0];
            result[1] = index[0];
            return result;
        }else {
            result[0] = index[0];
            result[1] = index[index.length-1];
            return result;
        }
    }

    public void searchRange(int[] nums, int start, int end, int target, int[] result2) {
        if (start > end || start < 0 || end < 0) {
            return;
        }
        if (start == end) {
            if (nums[start] == target) {
                result2[start] = 1;
            } else {
                result2[start] = -1;
            }
            return;
        }

        int middle = start + ((end - start) >> 1);
        //这里必须对middle进行判断 因为分组只会处理middle之前的数据和middle之后的数据
        if (nums[middle] == target) {
            result2[middle] = 1;
        } else {
            result2[middle] = -1;
        }
        searchRange(nums, start, middle - 1, target, result2);
        searchRange(nums, middle + 1, end, target, result2);
    }


    public static void main(String[] args) {
        int[] testArray = new int[]{5,7,7,8,8,10};
        SearchRange searchRange = new SearchRange();
//        System.out.println(binarySearch.search(testArray, 13));
        System.out.println(Arrays.toString(searchRange.searchRange(testArray, 8)));
    }
}
