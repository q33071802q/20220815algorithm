package leetcode.array.sum;

import java.util.Arrays;

/**
 * leetcode 209.
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray,return 0 instead.
 * <p>
 * 分析 ：
 * 给定一个数组和一个目标值，问需要数组中几个数相加与nums相等或者更大 并从中选出一个最小的数组 是最小的值 意思就是刚刚超过或者等于target的 不是最小的数组长度  并返回其长度
 * <p>
 * 它代表的是我有一个数 而不是这个数满足题目的条件  这时候有两个分支   1.变成二维数组 将每个数组对应的真正数据存储起来 2.每个数写入的时候对其做限制 怎么限制呢 不解 限制不了我觉得
 *
 *
 * <p>
 * 思路：
 * 必须先从小到大排序 然后才有解的可能  那这样的话没有排序的意义了
 * 1.从小到大排序
 * 2.将每个数找到对应的数组个数
 * 3.循环判断找到数组最小的结果集
 * <p>
 * 那这样不就成了一个妥妥的动态规划法了么 寻找一个最优解 动态规划法？ 0 1背包
 * <p>
 * 动态规划法
 * 1.状态转移方程
 * 2.物品的总量 target
 * 3.数组标记是否放入
 * <p>
 * 研究了一下 没有递推公式 所以不适合动态规划法 可以试试回溯法
 * <p>
 * 回溯法也不可以 因为是需要连续的  题目一开始理解错了  需要得到的是连续的子序列
 * 那问题就简单多了  思路 从每个位置开始求和 在大于target的结果集中找到最小的 就是结果集
 * <p>
 * 暴力解法 解决不了就是编程水平的问题 求最小长度
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen3(int target, int[] nums) {
        int subLength = 0;
        int i = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                subLength = j - i + 1;
                if (result > subLength) {
                    result = subLength;
                }
                sum -= nums[i++];
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    /**
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int subLength = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    if (result > subLength) {
                        result = subLength;
                    }
                    break;
                }
            }
        }
        if (result == Integer.MAX_VALUE) {
            return 0;
        }
        return result;
    }

    public int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        int[][] result = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                if (temp < target) {
                    temp += nums[j];
                    result[i][j] = nums[j];
                } else {
                    break;
                }
            }
        }
        //统计非0的次数
        int[] result0 = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int temp = 0;
            int count = 0;
            int[] ints = result[i];
            for (int anInt : ints) {
                if (anInt != 0) {
                    count++;
                    temp += anInt;
                }
            }
            if (temp >= target) {
                result0[i] = count;
            }
        }

        int min = result0[0];
        for (int i : result0) {
            if (min > i && i != 0) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int[] nums = new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen3(15, nums));
    }
}
