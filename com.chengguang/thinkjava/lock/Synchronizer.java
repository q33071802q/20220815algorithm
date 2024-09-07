package thinkjava.lock;

public class Synchronizer{
  Lock lock = new Lock();

  public void doSynchronized() throws InterruptedException{
    this.lock.lock();
      //critical section, do a lot of work which takes a long time
    this.lock.unlock();
  }

  public static void main(String[] args) {
    Synchronizer synchronizer = new Synchronizer();
    for (int i = 0; i < 3; i++) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            synchronizer.doSynchronized();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }).start();
    }
  }

}