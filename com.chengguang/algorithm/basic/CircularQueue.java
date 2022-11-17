package algorithm.basic;

/***
 * 循环队列 -》解决数据搬运  阻塞队列  并发队列 线程安全问题 CAS原子操作避免锁 实现无锁并发
 *
 * 对于大多数资源有限的场景 没有空间资源的时候 都可以通过队列这种数据结构来实现请求排队
 */
public class CircularQueue {
    private String[] items;
    private int n;

    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        //队列满了
        if ((tail + 1) % n == head) return false;
        this.items[head] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue(){
        //队列为空
        if (head == tail) return null;
        String item = this.items[head];
        head = (head+1)%n;
        return item;
    }
}
