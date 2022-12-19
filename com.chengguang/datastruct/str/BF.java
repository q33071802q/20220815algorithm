package datastruct.str;

public class BF {
    /**
     * 拿模式串与主串中所有字串匹配 看是否有能匹配的字串
     * 时间复杂度O（m*n）
     *
     * @param a 主串
     * @param b 模式串
     * @return
     */
    public static int bF(String a, String b) {
        int m = a.length();
        int n = b.length();
        int k = 0;
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        /**
         * 比如abcde abc 那么匹配的次数就是5-3 = 2 abc bcd cde
         */
        for (int i = 0; i <= m - n; i++) {
            for (int j = 0; j < n; j++) {
                /*
                i表示主串的开始位置 j表示模式串开始的位置
                i+j的意思表示从主串的哪个位置开始与模式串进行匹配
                 */
                if (a1[i + j] == b1[j]) {
                    k++;
                } else {
                    break;
                }
            }
            /*
            当匹配完模式串发现k的大小与模式串的长度相等
            则表明找到了该串
             */
            if (k == n) {
                return i;
            }
        }
        return -1;
    }

    /**
     * rk算法是借助哈希算法对BF算法的改造，
     * 即对每个子串分别求哈希值，
     * 然后拿子串的哈希值与模式串的哈希值比较，
     * 减少了比较的时间。
     *
     * @param a
     * @param b
     * @return
     */
    public static int rk(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[] hash = new int[m - n + 1];
        int[] table = new int[26];
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        /*
        将26的次方存储到表里
         */
        int s = 1;
        for (int j = 0; j < 26; j++) {
            table[j] = s;
            s *= 26;
        }
        /**
         * 将每个字串生成哈希值 并存到表中
         */
        for (int i = 0; i < m - n; i++) {
            s = 0;
            for (int j = 0; j < n; j++) {
                s += (a1[i + j] - 'a') * table[n - 1 - j];
            }
            hash[i] = s;
        }
        /**
         * 获取模式串的哈希值
         */
        s = 0;
        for (int j = 0; j < n; j++) {
            s += (b1[j] - 'a') * table[n - 1 - j];
        }
        /**
         * 比较子串大小 相等则表示已经匹配
         */
        for (int j = 0; j < m - n + 1; j++) {
            if (hash[j]==s){
                return j;
            }
        }
        return -1;
    }
}
