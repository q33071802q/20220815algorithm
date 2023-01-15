package leetcode.array.search;

/**
 * given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well
 * <p>
 * must not use any built-in exponent function or operator
 * <p>
 * 分析 获取平方根 并且在没有整数根的时候 返回比该数最小的整数
 * x*x->x^2 相当于给一个数 知道它是由哪个数自己乘自己的结果
 * 因为无法穷举 所以无法使用贪心法 这个跟二分法有什么关系呢。。如果给了取值范围那还挺简单 直接for循环在里面一个个试就完了
 * 但是现在就是非负数 这个时间范围太大了 是不是有什么公式啊 不然咋求平方根 如果每个数都是一个从0位置开始的数组 那必然它的平方根就在这个范围内
 * 所以范围定下了
 * <p>
 * 思路
 * 1.生成一个数组
 * 2.二分查找这个数组范围内符合平方的结果
 * 1.求中位数
 * 2.从中位数左右搜索
 * <p>
 * 这个牛逼了  2147395599 数组装不下 没法初始化 说明这种数据结构无法支撑运算 必须转化乘long才能存储 那么有没有别的办法呢
 *
 * 直接while就完事了 注意大数int精度丢失的问题 需要转换成long进行处理
 */
public class Sqrt {
    public int mySqrt2(int x) {
        int i = 0;
        int j = x;
        while (i <= j) {
            int middle = i + (j - i) / 2;
            if ((long)middle * middle == x) {
                return middle;
            } else if ((long)middle * middle > x) {
                j = middle - 1;
            } else if ((long)middle * middle < x) {
                i = middle + 1;
            }
        }
        return i - 1;
    }

    public int mySqrt(int x) {
        long[] nums = new long[x + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        return searchBinary(x, 0, nums.length, nums);
    }

    private int searchBinary(int target, int start, int end, long[] nums) {
        if (start > end) {
            return end;
        }
        int middle = start + (end - start) / 2;
        if (middle * middle == target) {
            return middle;
        } else if (middle * middle < target) {
            return searchBinary(target, middle + 1, end, nums);
        } else if (middle * middle > target) {
            return searchBinary(target, start, middle - 1, nums);
        }
        return -1;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt2(2147395599));
    }
}
