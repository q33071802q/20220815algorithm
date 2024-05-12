package thinkjava.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class SimplePriorities9ThreadFactory implements ThreadFactory {
    Random random = new Random();

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        int i = random.nextInt(3);
        switch (i) {
            case 0:
                t.setPriority(Thread.MIN_PRIORITY);
                break;
            case 1:
                t.setPriority(Thread.NORM_PRIORITY);
                break;
            case 2:
                t.setPriority(Thread.MAX_PRIORITY);
                break;
        }
        return t;
    }
}

public class SimplePriorities9 implements Runnable {
    private int countDown = 5;
    private volatile double d;

    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new SimplePriorities9ThreadFactory());
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities9());
        }
        exec.execute(new SimplePriorities9());
        exec.shutdown();
    }
}
