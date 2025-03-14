package juc;

import java.util.concurrent.*;

public class TestCountDownLatch {
//    private static final ThreadPoolExecutor executorService =
//            new ThreadPoolExecutor(4,5,0L, TimeUnit.MINUTES,
//                    new ArrayBlockingQueue<>(1));

    public static void main(String[] args) {
//        System.out.println(executorService.getActiveCount());
        CountDownLatch latch = new CountDownLatch(5);
        LatchDemo ld = new LatchDemo(latch);
        long start = System.currentTimeMillis();
        System.out.println("active begin:"+Thread.activeCount());

        for (int i = 0; i < 5; i++) {
            new Thread(ld).start();
        }

        System.out.println("active work:"+Thread.activeCount());

        try {
            latch.await();
        } catch (InterruptedException e) {

        }
        System.out.println("----");

        long end = System.currentTimeMillis();

        System.out.println("耗费时间：" + (end - start));
        System.out.println("active end:"+Thread.activeCount());
//        System.out.println("end available:" + executorService.getCompletedTaskCount());
//        executorService.shutdown();
    }
}

class LatchDemo implements Runnable {
    private CountDownLatch latch;
//    private ThreadPoolExecutor threadPoolExecutor;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
//        this.threadPoolExecutor = threadPoolExecutor;
    }

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
//                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
//        System.out.println("completed:" +  threadPoolExecutor.getCompletedTaskCount());
//        System.out.println("available:" +  threadPoolExecutor.getTaskCount());
        System.out.println("countDown前:"+Thread.activeCount());
        latch.countDown();
        System.out.println("countDown后:"+Thread.activeCount());
//        System.out.println("completed after:" +  threadPoolExecutor.getCompletedTaskCount());
//        System.out.println("available after:" +  threadPoolExecutor.getTaskCount());
//        System.out.println("count:" + latch.getCount());
    }
}
