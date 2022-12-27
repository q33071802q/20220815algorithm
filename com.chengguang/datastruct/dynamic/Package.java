package datastruct.dynamic;

public class Package {
    private int maxW = Integer.MIN_VALUE; //结果重量
    private int[] weight = {2, 2, 4, 6, 3}; //每个物品的重量
    private int n = 5; //物品个数
    private int w = 9; //背包承受的最大重量
    private boolean[][] mem = new boolean[5][10]; //备忘录 默认值false

    /**
     * 回溯法加备忘录的写法
     *
     * @param i  表示将要决策第几个物品是否装入背包
     * @param cw 表示当前背包中物品的总重量
     */
    public void f(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (mem[i][cw]) {
            return;
        }
        mem[i][cw] = true;
        f(i + 1, cw);
        if (cw + weight[i] < w) {
            f(i + 1, cw + weight[i]);
        }
    }

    private boolean[][] states = new boolean[5][10];

    /**
     * 动态规划法求0。1背包问题
     * state[n][w+1] 记录每层可以达到的不同状态
     * state[1][0] state[1][2] state[1][4]
     *
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承担的重量
     * @return
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] c = new boolean[n][w + 1];
        states[0][0] = true;
        states[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) { //动态规划状态转移
            for (int j = 0; j <= w; ++j) { //不把第i个物品放入背包
                if (states[i - 1][j] == true) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j < w - weight[i]; ++j) {
                if (states[i - 1][j] == true) { //把第i个物品放入背包
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i] == true) {
                return i;
            }
        }
        return 0;
    }
}
