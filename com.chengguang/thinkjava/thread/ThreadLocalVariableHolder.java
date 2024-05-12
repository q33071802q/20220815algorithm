package thinkjava.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable{
    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this.toString()+"-"+id);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "Accessor{" +
                "id=" + id +
                '}'+ThreadLocalVariableHolder.get();
    }
}

/**
 * 为每个线程分配自己的
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value =
            new ThreadLocal<Integer>(){
                private Random random = new Random(47);
                protected synchronized Integer initialValue(){
                    return random.nextInt(1000);
                }
            };

    public static void increment(){
        value.set(value.get()+1);
    }

    public static int get(){
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.submit(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        exec.shutdown();
    }
}
