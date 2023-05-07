package leetcode.array.remove;

import java.util.Arrays;

/**
 * leetcode 26
 * remove duplicates from Sorted Array
 * <p>
 * Given an integer array nums sorted in non-decreasing order,remove the duplicates in-place
 * such that each unique element appears only once.The relative order of the elements should
 * be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages , must instead
 * have the result be placed in the first part of the array nums.More formally,if there are
 * k elements after removing the duplicates,then the first k elements of nums should hold
 * the final result.It does not matter what you leave beyond the first k elements.
 * <p>
 * Return K after placing the final result in the first k slots of nums
 * <p>
 * Do not allocate extra space for another array.You must do this by modifying the input
 * array in-place with O(1) extra memory.
 * <p>
 * 分析：
 * 要求移除数组中重复的元素，然后将剩下的元素全部放在数组的头，中间不要留有空白地址空间的元素
 * 去重，下意识会想用哈希直接滤重 但是会占用额外的空间 要求空间复杂度为O（1）所以不能用这个方案
 * 需要确定每个遍历的数在前面是否出现 那很自然地可以想到对每个数后面剩下的数组遍历判断是否与当前的相等
 * <p>
 * 又回到了这个问题 我如何知道对一个数要遍历几次  是不是得事先统计每个数出现的次数 如何统计呢 先循环一遍 计算这个数在后面存在的个数
 * 那么在后面移动的时候 把这个数带进去循环
 * <p>
 * 思路：
 * I蛮力法 节约空间 但是时间复杂度太高了 居然达到了O（n^4）
 * 1.对数组进行遍历，对每个位置的数与后面的各个位置的数进行对比
 * 2.如果后面的位置数与当前相等，则说明有重复的，是需要移除的，如何移除，将后面的数往前移动 移动几次？ 对每个数进行计算
 * <p>
 * 看了其他人的提交 发现双指针思想真的是无处不在
 * 直接一个指针指向每个需要处理的位置 然后另一个指针指向后面的数组 是啊 人家没让你移动 只是计个数而已 然后把重复的覆盖一下 为什么你整这么麻烦
 *
 * 不是我的思维僵硬 我的思维比较直 这个人的思维简直了 太牛了
 */
public class RemoveDuplicates {

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[head]!=nums[i]){
                nums[++head] = nums[i];
            }
        }
        return head+1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int h = 0;
        for (int i = 0; i < nums.length - h; i++) {
            int z = 0;
            for (int j = i + 1; j < nums.length - h; j++) {
                if (nums[i] == nums[j]) {
                    z++;
                }
            }
            for (int j = i + 1; j < nums.length - h; j++) {
                if (nums[i] == nums[j]) {
                    for (int l = 0; l < z; l++) {
                        for (int k = i + 1; k < nums.length - 1; k++) {
                            nums[k] = nums[k + 1];
                        }
                        h += 1;
                    }
                }
            }
        }
        return nums.length - h;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates.removeDuplicates2(arr));
    }
}
