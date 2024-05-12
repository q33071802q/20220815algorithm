package thinkjava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class A1 implements Runnable {
    boolean flag = false;

    @Override
    public synchronized void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("A setting flag = true");
        flag = true;
    }
}

class BusyWait implements Runnable {
    A1 a = new A1();
    long start, end;

    public synchronized A1 getA() {
        return a;
    }

    public static BusyWait buildBusyWait(A1 a) {
        return new BusyWait(a);
    }

    public BusyWait(A1 a) {
        this.a = a;
    }

    @Override
    public synchronized void run() {
        System.out.println("Busy a.flag = " + a.flag);
        while (!Thread.interrupted()) { //这样写线程就可以控制开关
            start = System.nanoTime(); //忙等待
            if (a.flag) { //等待A1线程执行完毕
                a.flag = false;
                System.out.println("Busy reset a.flag = false");
                end = System.nanoTime();
                System.out.println("Busy Waiting "+(end-start)+" nanoseconds");
            }
        }
    }
}

class BetterWait implements Runnable{
    private A1 a = new A1();

    public synchronized A1 getA() {
        return a;
    }

    public BetterWait(A1 a) {
        this.a = a;
    }

    public static BetterWait buildBetterWait(A1 a){
        return new BetterWait(a);
    }

    @Override
    public void run() {
        System.out.println("Better a.flag = "+a.flag);
        while (!a.flag){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            a.flag = false;
            System.out.println("Better reset a.flag = false");
        }
    }
}

public class Ex22 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
//        BusyWait busyWait = BusyWait.buildBusyWait(new A1());
//        exec.execute(busyWait.a);
//        exec.execute(busyWait);
        System.out.println();
        BetterWait better = BetterWait.buildBetterWait(new A1());
        exec.execute(better.getA());
        exec.execute(better);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            System.out.println("sleep interrupted in main()");
        }
        synchronized(better) {
            System.out.println("Sending better.notifyAll()");
            better.notifyAll();
        }
        exec.shutdown();
    }
}
