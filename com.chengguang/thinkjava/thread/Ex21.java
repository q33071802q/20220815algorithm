package thinkjava.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * waiting time notify
 */
class A implements Runnable{
    private volatile boolean signal = false;
    @Override
    public synchronized void run() {
        while (!signal){
            System.out.println("A.run() wait()");
            try {
                wait(); //阻塞
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                System.out.println("Leaving A run()");
            }
            signal = true; //唤醒后就执行到这个位置了 变为true 就跳出循环了
            System.out.println("A is done waiting");
        }
    }

    public synchronized void message(){
        System.out.println("Hi from A");
    }
}

/**
 * 获取第一个Runnable的引用
 */
class B implements Runnable{
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (a){
            System.out.println("B.run() a.notifyAll()");
            a.notifyAll(); //在B线程中唤醒 wait状态的A
        }
    }
}

public class Ex21 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        B b = new B(new A());
        exec.execute(b.getA());
        b.getA().message();
        exec.execute(b);
        TimeUnit.MILLISECONDS.sleep(2500);
        exec.shutdownNow();
    }
}
