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

    /**
     * 动态规划法求0。1背包问题
     * state[n] 记录每层可以达到的不同状态
     * 一维数组的处理方式 降低内存占用
     *
     * @param items 物品重量集合
     * @param n     物品个数
     * @param w     背包可承担的重量
     * @return
     */
    public int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        states[items[0]] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = w - items[i]; j > 0; --j) {
                if (states[j] == true) {
                    states[j + items[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[i] == true) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 不同重量、不同价值、不可分割的物品
     * 也就是对应的物品有价值了
     */
    public class Quan {
        private int maxV = Integer.MAX_VALUE;
        private int[] items = {2, 2, 4, 6, 3}; //物品重量
        private int[] value = {3, 4, 8, 9, 6}; //物品价值
        private int n = 5; //物品个数
        private int w = 9; //背包可以承受的总价值

        /**
         * 回溯法是真的牛逼
         *
         * @param i
         * @param cw
         * @param cv
         */
        public void f(int i, int cw, int cv) {
            if (cw == w || i == n) {
                maxV = cv;
                return;
            }
            f(i + 1, cw, cv);
            if (cw + items[i] <= w) {
                f(i + 1, cw + items[i], cv + value[i]);
            }
        }

        /**
         * 动态规划法与回溯法的区别在于 后者是递归树 前者是一个状态转移方程
         * 求解分为n个阶段 每个阶段决策一个物品是否放入背包中
         * 决策后 背包中的物品总重量以及总价值 有多种情况 也就是达到不同的状态
         * 实现：
         * 二维数组states[n][w+1]记录每层可以达到的不同状态
         * 存储当前状态对应的最大总价值
         * 把每一层中(i,cw)重复的状态合并，只记录cv值最大的那个状态，
         * 然后基于这些状态来推导下一层的状态
         *
         * @param weight 每个物品的重量
         * @param value  每个物品的价值
         * @param n      物品的个数
         * @param w      背包可以承担的重量
         * @return
         */
        public int knapsack3(int[] weight, int[] value, int n, int w) {
            //记录当前节点的最大总价值
            int[][] states = new int[n][w + 1];
            //初始化states
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < w + 1; ++j) {
                    states[i][j] = -1;
                }
            }
            states[0][0] = 0;
            states[0][weight[0]] = value[0];
            for (int i = 1; i < n; ++i) { //状态转移方程
                for (int j = 0; j <= w; ++i) { //不放入i
                    if (states[i - 1][j] >= 0) {
                        states[i][j] = states[i - 1][j];
                    }
                }
                for (int j = 0; j <= w - weight[i]; ++j) { //放入i
                    if (states[i - 1][j] >= 0) {
                        int v = states[i - 1][j] + value[i];
                        if (v > states[i][j + weight[i]]) {
                            states[i][j + weight[i]] = v;
                        }
                    }
                }
            }
            int maxValue = -1;
            for (int j = 0; j <= w; ++j) {
                if (states[n - 1][j] > maxValue) {
                    maxValue = states[n - 1][j];
                }
            }
            return maxValue;
        }
    }

    /**
     * 找到大于等于200的值中最小的价格
     * states[n][x] x代表总价格
     *
     * @param items 商品价格
     * @param n     商品个数
     * @param w     满减条件
     */
    public static void double11advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][3 * w + 1];
        states[0][0] = true;
        states[0][items[0]] = true;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= 3 * w; ++j) {
                if (states[i - 1][j] == true) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= 3 * w - items[i]; ++j) {
                if (states[i - 1][j] == true) {
                    states[i][j + items[i]] = true;
                }
            }
        }
        int j;
        for (j = w; j < 3 * w + 1; ++j) {
            if (states[n - 1][j] == true) {
                break;
            }
        }
        if (j == -1) {
            return;
        }
        for (int i = n - 1; i >= -1; --i) {
            if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
                System.out.print(items[i]+" ");
                j = j-items[i];
            }
        }
        if (j!=0){
            System.out.println(items[0]);
        }
    }
}
