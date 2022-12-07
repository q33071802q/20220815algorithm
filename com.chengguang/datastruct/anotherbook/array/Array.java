package datastruct.anotherbook.array;

public class Array {
    /**
     * 数组元素
     */
    public int data[];
    /**
     * 数组长度
     */
    private int n;
    /**
     * 定义的实际个数
     */
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 根据下标获取对应的元素
     *
     * @param index
     * @return
     */
    public int find(int index) {
        if (index < 0 || index > n) {
            return -1;
        }
        return data[index];
    }

    /**
     * 在固定的位置插入元素
     *
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        //满了
        if (count == n) {
            System.out.println("没有可以插入的位置");
            return false;
        }

        //索引不在范围内
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }

        //有合适的位置 将要插入的索引的位置留出来 索引右边的元素统统往右边挪
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        for (int i = index;i<count;i++){
            data[i] = data[i+1];
        }
        --count;
        return true;
    }

    public void printAll(){
        for (int i = 0;i<count;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0,3);
        array.delete(0);
        array.printAll();
    }
}
