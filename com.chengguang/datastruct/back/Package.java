package datastruct.back;

/**
 * 0.1背包问题
 */
public class Package {
    public int maxW = Integer.MIN_VALUE;

    /**
     * @param i     具体到哪个物品了
     * @param cw    已经装进去的物品总量和
     * @param items 每个物品的重量
     * @param n     物品个数
     * @param w     背包重量
     */
    public void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { //cw=w表示装满了 i=n 表示已经考察完所有的物品了
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        //选择不将该物品放进去
        f(i + 1, cw, items, n, w);
        //判断选择物品是否能放进背包 可以的话将物品放入背包
        if (cw + items[i] <= w) {
            f(i+1,cw+items[i],items,n,w);
        }
    }
}
