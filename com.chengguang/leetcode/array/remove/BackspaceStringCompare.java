package leetcode.array.remove;

import java.util.Stack;

/**
 * Given two strings s and t ,return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text,the text will continue empty.
 * <p>
 * can you solve it O(n) or O(1) space
 * <p>
 * 分析 判断两个字符串是否相等 等于判断字符串中每个字符是否相等 双指针试试
 * 不仅要判断下一个有没有# 还要判断后面还有没有# 只要有 必然能消除对应的上一个字符
 * 是不是可以先处理#呢 把字符串的所有#都处理掉，再对比 ，不就很简单了 有道理
 * 那么怎么消除呢 每个#对应它前面的一个字符 如果#的前面还是#呢 配对 出现一个# 找到
 * <p>
 * 遍历 如果出现了# 那么将数组往前移动两个位置 试试 如果第一位出现了 则往前移动一位
 * <p>
 * 不存在一个个比较 因为#的位置出现指的是很前面的一个数
 * <p>
 * 那么只能先优化各自的数组 如何优化呢
 * 先解决子问题 如何压缩具有符号栈的数组？
 * 1.分为两个栈 先遍历计算两个栈的大小 然后初始化 再把元素按顺序放入
 * 2.根据符号栈的元素个数 从尾部开始遍历 一个个移出
 *
 * 也做不了 因为栈无法判断#是在哪个位置移除
 *
 * 1。用栈
 * 2。遍历
 * 3。分冶
 *
 * 全部不行 我服了 看下答案吧 直接用栈 有个解法特别牛逼 水平达不到 看不懂  但是做一人之下 万人之上 还是可以的
 *
 * 1.直接利用jdk的栈解法
 * 2。利用stringbuilder可删除的性质解法
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare3(String s,String t){
        return cleanString(s).equals(cleanString(t));
    }

    private String cleanString(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '#'){
                sb.append(chars[i]);
            }else {
                if (sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }


    public boolean backspaceCompare2(String s,String t){
        return buildStack(s).equals(buildStack(t));
    }

    public Stack<Character> buildStack(String str){
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!='#'){
                stack.push(chars[i]);
            }else {
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        return stack;
    }

    public boolean backspaceCompare(String s, String t) {

        char[] resultA = getResultA(s);
        char[] resultA1 = getResultA(t);

        if (resultA.length == resultA1.length && resultA.length == 0) {
            return true;
        }

        for (int i = 0; i < resultA1.length; i++) {
            if (resultA[i] == resultA1[i]) {
                return true;
            }
        }

        return false;
    }

    private static char[] getResultA(String s) {
        char[] sChars = s.toCharArray();
        int j = 0;
        int h = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '#') {
                j++;
            } else {
                h++;
            }
        }
        char[] charChars = new char[h];
        int a = 0;
        int b = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == '#') {
                a++;
            } else {
                charChars[b++] = sChars[i];
            }
        }

        char[] result = new char[b - a];
        for (int i = 0; i < charChars.length - a; i++) {
            result[i] = charChars[i];
        }
        return result;
    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare3("a##c", "#a#c"));
    }
}
