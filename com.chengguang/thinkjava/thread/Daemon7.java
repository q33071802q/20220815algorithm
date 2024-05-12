package thinkjava.thread;

import java.util.concurrent.TimeUnit;

/**
 * 起了一个线程 这个线程是守护线程 然后守护线程里又起了一堆线程 一直在做yield操作
 */
class Daemon implements Runnable {
    private Thread[] t = new Thread[30];

    @Override
    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn "+i+" started");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " +
                    t[i].isDaemon() + ", ");
        }
        while (true){
            Thread.yield();
        }
    }
}

 class DaemonSpawn implements Runnable{
    @Override
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}

public class Daemon7{
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d="+d.isDaemon()+", ");
         TimeUnit.SECONDS.sleep(1);

    }
}