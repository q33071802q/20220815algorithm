package thinkjava.lock;

public class Lock{
  private boolean isLocked      = false;
  private Thread  lockingThread = null;

  public synchronized void lock() throws InterruptedException{
    long now = System.currentTimeMillis();
    System.out.println(Thread.currentThread()+" isLocked:"+isLocked +":"+now);
    while(isLocked){
      System.out.println(Thread.currentThread()+" wait");
      wait();
    }
    isLocked      = true;
    System.out.println(Thread.currentThread()+" after isLocked:"+isLocked);
    lockingThread = Thread.currentThread();
  }

  public synchronized void unlock(){
    long now = System.currentTimeMillis();
    System.out.println("unlock time now"+now);
    if(this.lockingThread != Thread.currentThread()){
      throw new IllegalMonitorStateException(
        "Calling thread has not locked this lock");
    }
    isLocked      = false;
    lockingThread = null;
    notify();
  }
}