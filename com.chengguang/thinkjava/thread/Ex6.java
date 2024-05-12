package thinkjava.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex6 implements Runnable{

    Random random = new Random();
    @Override
    public void run() {
        try {
            int t = 1000 * random.nextInt(10);
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println("Slept "+t/1000+" seconds");
            return;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        if (args.length<1){
//            System.out.println("Usage");
//        }
//        if (args.length == 1){
            int n = Integer.parseInt("10");
            ExecutorService exec = Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++) {
                exec.execute(new Ex6());
            }
            exec.shutdown();
//        }
    }
}
