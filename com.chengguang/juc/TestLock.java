package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket, "1号").start();
        new Thread(ticket, "2号").start();
        new Thread(ticket, "3号").start();
    }
}

class Ticket implements Runnable {
    private int tick = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (; ; ) {
//            System.out.println(Thread.currentThread().getName()+
//                    " alive:"+Thread.currentThread().isAlive());
            lock.lock();
            try {
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName() +
                            "剩余售票：" + (--tick));
                }
            }finally {
                            lock.unlock();
            }


        }
    }
}
