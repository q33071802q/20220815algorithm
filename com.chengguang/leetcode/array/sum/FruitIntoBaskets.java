package leetcode.array.sum;

import algorithm.sort.In;
import datastruct.anotherbook.array.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 904 Fruit into Baskets
 * <p>
 * you are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit
 * the i th tree produces.
 * <p>
 * you want to collect as much fruit as possible.However,the owner has some strict rules
 * that you must follow：
 * <p>
 * you only have two baskets,and each basket can only hold a single type of fruit. There is
 * no limit on the amount of fruit each basket can hold.
 * <p>
 * starting from any tree of your choice,you must pick exactly one fruit from every tree
 * (including the start tree) while moving to the right.The picked fruits must fit in
 * one of your baskets.
 * <p>
 * Once you reach a tree with fruit that cannot fit in your baskets.you must stop
 * <p>
 * Given the integer array fruits,return the maximum number of fruits you can pick.
 * <p>
 * 分析
 * 只有两个篮子 每个篮子还只能装一种 很简单 滑动窗口 每个位置都计算output 然后取最大值即可
 * <p>
 * 怎么把下面这个写成动态的呢 思想落伍了 不要想着双循环的那种双指针做法
 */
public class FruitIntoBaskets {

    public int totalFruit2(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right],cnt.getOrDefault(fruits[right],0)+1);
            while (cnt.size()>2){
                cnt.put(fruits[left],cnt.get(fruits[left])-1);
                if (cnt.get(fruits[left])==0){
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }


    public int totalFruit(int[] fruits) {
        int[] arr = new int[2];
        int max = 2;
        for (int i = 0; i < fruits.length - 1; i++) {
            arr[0] = fruits[i];
            for (int j = i + 1; j < fruits.length; j++) {
                if (fruits[j] != fruits[i]) {
                    arr[1] = fruits[j];
                    break;
                }
            }
            int sum = 2;
            for (int j = i + 2; j < fruits.length; j++) {
                int z = 0;
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] == fruits[j]) {
                        z++;
                        sum++;
                    }
                    if (z == 0) {
                        break;
                    }
                }
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new FruitIntoBaskets().totalFruit2(new int[]{0, 1, 2, 2}));
//        System.out.println(new FruitIntoBaskets().totalFruit(new int[]{0,1,2,2}));
    }
}
