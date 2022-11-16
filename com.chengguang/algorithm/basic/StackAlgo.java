package algorithm.basic;

public class StackAlgo {
    /**
     * 数组
     */
    private String[] items;
    /**
     * 栈中的元素个数
     */
    private int count;
    /**
     * 栈大小
     */
    private int n;

    public StackAlgo(int count, int n) {
        this.items = new String[n];
        this.count = count;
        this.n = n;
    }

    /**
     * 注意边界的判断
     * @param item
     * @return
     */
    public boolean push(String item){
        if (count==n) return false;
        this.items[count] = item;
        count++;
        return true;
    }

    /**
     * 弹出 就是把记录的最后一个位置获取到 然后count-- 指向前面一个数即可
     * @return
     */
    public String pop(){
        if (count==0) return null;
        String item = this.items[count-1];
        count--;
        return item;
    }

}
