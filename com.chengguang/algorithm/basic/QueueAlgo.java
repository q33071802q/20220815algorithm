package algorithm.basic;

public class QueueAlgo {
    private String[] items;
    /**
     * 数组大小
     */
    private int n = 0;
    /**
     * 队头下标
     */
    private int head = 0;
    /**
     * 队尾下标
     */
    private int tail = 0;

    public QueueAlgo(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        if (tail == n) return false;
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue(){
        if (head == tail) return null;
        String item = items[head];
        ++head;
        return item;
    }
}
