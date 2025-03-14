package juc;

public class TestCompareAndSwap {
    public static void main(String[] args) {
        CompareAndSwap compareAndSwap = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                    int exceptedValue = compareAndSwap.get();
                    boolean flag = compareAndSwap.compareAndSet(exceptedValue,
                            (int) (Math.random() * 101));
                    System.out.println(Thread.currentThread().getName()+" front" +
                            ":"+exceptedValue+
                            " " +
                            "result" +
                            ":"+compareAndSwap.get());


            }).start();
        }
    }

}

class CompareAndSwap{
    private int value;
    //获取内存值
    public synchronized int get(){
        return value;
    }
    //比较并替换
    public synchronized int compareAndSwap(int exceptedValue,
                                           int newValue){
        int oldValue = value;

        if (oldValue == exceptedValue){
            this.value = newValue;
        }

        return oldValue;
    }

    //设置
    public synchronized boolean compareAndSet(int exceptedValue,
                                              int newValue){
        return exceptedValue == compareAndSwap(exceptedValue, newValue);
    }
}
