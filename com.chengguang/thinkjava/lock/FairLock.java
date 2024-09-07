package thinkjava.lock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FairLock {
    private boolean           isLocked       = false;
    private Thread            lockingThread  = null;
    private List<QueueObject> waitingThreads =
            new ArrayList<QueueObject>();

  public void lock() throws InterruptedException{
    QueueObject queueObject           = new QueueObject();
    boolean     isLockedForThisThread = true;
    synchronized(this){
        waitingThreads.add(queueObject);
    }

    while(isLockedForThisThread){
      synchronized(this){
        isLockedForThisThread =
            isLocked || waitingThreads.get(0) != queueObject;
        if(!isLockedForThisThread){
          isLocked = true;
           waitingThreads.remove(queueObject);
           lockingThread = Thread.currentThread();
           return;
         }
      }
      try{
        queueObject.doWait();
      }catch(InterruptedException e){
        synchronized(this) { waitingThreads.remove(queueObject); }
        throw e;
      }
    }
  }

  public synchronized void unlock(){
    if(this.lockingThread != Thread.currentThread()){
      throw new IllegalMonitorStateException(
        "Calling thread has not locked this lock");
    }
    isLocked      = false;
    lockingThread = null;
    if(waitingThreads.size() > 0){
      waitingThreads.get(0).doNotify();
    }
  }

  public static class Test{
      private final FairLock fairLock = new FairLock();

      public static void main(String[] args) throws InterruptedException {
          Test test = new Test();
          test.testLockAndUnlock();
      }

      void testLockAndUnlock() throws InterruptedException {
          Thread t1 = new Thread(() -> {
              try {
                  fairLock.lock();
                  System.out.println("Thread 1 acquired the lock");
                  Thread.sleep(500); // 模拟线程1持有锁一段时间
                  fairLock.unlock();
                  System.out.println("Thread 1 released the lock");
              } catch (InterruptedException e) {
                  fail("Thread 1 was interrupted");
              }
          });

          Thread t2 = new Thread(() -> {
              try {
                  fairLock.lock();
                  System.out.println("Thread 2 acquired the lock");
                  fairLock.unlock();
                  System.out.println("Thread 2 released the lock");
              } catch (InterruptedException e) {
                  fail("Thread 2 was interrupted");
              }
          });

          t1.start();
          Thread.sleep(100); // 确保t1先获取锁
          t2.start();

          t1.join();
          t2.join();
      }

      void testReentrantLock() throws InterruptedException {
          fairLock.lock();
          assertThrows(IllegalMonitorStateException.class, () -> fairLock.unlock(),
                  "Thread should not unlock the lock it did not acquire");

          fairLock.unlock();
      }
  }

}