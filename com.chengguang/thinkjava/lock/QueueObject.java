package thinkjava.lock;

import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueObject {

  private boolean isNotified = false;

  public synchronized void doWait() throws InterruptedException {
    while(!isNotified){
      System.out.println("线程等待");
      System.out.println(Thread.currentThread().getState());
      this.wait();
      System.out.println(Thread.currentThread().getState());
    }
    System.out.println("线程被唤醒");
    System.out.println(Thread.currentThread().getState());
    this.isNotified = false;
  }

  public synchronized void doNotify() {
    this.isNotified = true;
    this.notify();
  }

  public boolean equals(Object o) {
    return this == o;
  }

  public static void main(String[] args) throws InterruptedException {
    QueueObject queueObject = new QueueObject();

    Thread waitingThread = new Thread(() -> {
      try {
        synchronized (queueObject) {
          queueObject.doWait();
        }
      } catch (InterruptedException e) {
        fail("Thread was interrupted");
      }
    });

    Thread observer = new Thread(()->{
      while (waitingThread.isAlive()){
        for (int i = 0; i < 10; i++) {
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          synchronized (queueObject){
            System.out.println("观察："+waitingThread.getState());
          }
        }
      }
    });

    waitingThread.start();
    observer.start();


    // 确保 waitingThread 已经在等待
    Thread.sleep(1000);

    assertTrue(waitingThread.isAlive(), "Thread should be waiting");

    synchronized (queueObject) {
      queueObject.doNotify();
    }

    waitingThread.join();

    assertFalse(waitingThread.isAlive(), "Thread should be notified and finished");
  }


}