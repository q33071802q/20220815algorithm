package leetcode.array.remove;

import java.util.Arrays;

/**
 * Given an integer arrays nums,move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 * <p>
 * Note must do this in-place without making a copy of the array.
 * <p>
 * 分析
 * 把数组中所有等于零的数，移动到数组末尾 很简单啊 直接双指针 比较 然后交换位置不就完了
 * 审题呀 移动的过程保持原有顺序 所以不能用这种交换的方式处理 那就只能移动位置了
 * <p>
 * 思路
 * 对每个元素判断 遇到遇到0 则将后面的元素都往前面移动一位 然后最后一位set 0 不推荐
 * 需要对每个数都计算个数 然后按照个数循环 会额外增加时间复杂度
 *
 * 思路2
 *      对每个为0的数 找它后面的数与它交换一下 不就能保持原有顺序么
 *      算法复杂度 O（n^2）
 *
 * 思路3
 *      能不能降低时间复杂度 看到别人解答 太强了 直接降低到O（n）了
 *      先通过一个for循环把非0的数移动前面去 再通过一个for循环把后面的数都设为0
 */
public class MoveZeroes {

    public void moveZeores3(int[] nums){
        if (nums.length == 0) return;
        int j = 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for (int i = j;i<nums.length;i++){
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums.length == 0) return;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] == 0){
                for (int j = i+1;j<nums.length;j++){
                    if (nums[j]!=0){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    //这种方式不好 需要对每个数都计算个数 然后按照个数循环 会额外增加时间复杂度
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int h = 0; //移动次数
        for (int i = 0; i < nums.length-h; i++) {
            if (nums[i] == 0) {
                for (int k = i; k < nums.length-1-h; k++) {
                    nums[k] = nums[k + 1];
                }
                h++;
                nums[nums.length-h] = 0;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes.moveZeores3(nums);
        System.out.println(Arrays.toString(nums));
    }
}
