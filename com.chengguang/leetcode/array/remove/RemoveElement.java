package leetcode.array.remove;

/**
 * Given an integer array nums and an integer val,remove all occurrences of val in nums in-place.
 * The relative order of the elements may be changed
 * <p>
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally,if there are k elements after removing the duplicates,then the first k elements of
 * nums should hold the final result.It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums
 * <p>
 * Do not allocate extra space for another array.You must do this by modifying the input array
 * in-place with O(1) extra memory
 * <p>
 * example:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * 分析：
 * 从数组中移除选择的索引位置元素 然后将移除的后面位置的数往前移动，最后返回数组删除后还剩的元素个数
 * 是不是可以投机取巧呢 因为他只是要知道数组删除后还剩下几个 哦 不行 还需要知道数组删除后里面的元素
 * 那有没有什么思路呢 遍历的时候移动不了位置 先找到数组中对应的几个数的索引 然后把索引后面的数往前移动
 * 是不是可以先找到有几个值呢 就把数组后面空出几个位置 val好求 就是数组里有几个相等的 但是nums怎么移动呢
 * 牛逼 移动然后回到原有的节点
 * 判断相等 就把该索引后面的数往前移一位 虽然时间复杂度高了点 但是起码能实现 人家题目要求也只是空间复杂度要求O（1）
 * 如果没有要求空间复杂度 直接创建一个新的空间 然后循环数组判断不相等就往新数组里存不就完了
 *
 * 思路：
 * 使用双指针 不相等的话不操作 左指针向右移动 相等的话将该位置的数与右指针数对换 并将右指针向左移动一位 直到左右指针相交结束
 */
public class RemoveElement {
    /**
     * 双指针
     *
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] != val) {
                i++;
            } else {
                nums[i] = nums[j];
                j--;
            }
        }
        return i;
    }

    public int removeElement4(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int h = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==val){
                for (int j =i;j<nums.length-1;j++){
                    nums[j] = nums[j+1];
                }
                h++; //移动次数
                nums[nums.length-h] = -1;
                i--;
            }
        }
        return nums.length-h;
    }

    /**
     * 双指针2
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement3(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[head] = nums[i];
                head++;
            }
        }
        return head;
    }

    /**
     * error
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int k : nums) {
            if (k != val) {
                j++;
            }
        }
        int[] result = new int[j];
        int z = 0;
        for (int num : nums) {
            if (num != val) {
                result[z] = num;
                z++;
            }
        }
        for (int i = 0; i < j; i++) {
            nums[i] = result[i];
        }
        return result.length;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement.removeElement4(arr, 2));
    }
}
