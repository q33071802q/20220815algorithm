package thinkjava.thread;

public class MoreBasicThreads8 {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 25; i++) {
                Thread t = new Thread(new LiftOff());
                t.setDaemon(true);
                t.start();
            }
            System.out.println("Wating for LiftOff");
        } finally {
            System.out.println("Finally out of main");
        }
    }
}

class LiftOff implements Runnable {
    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public LiftOff() {
    }

    public String status(){
        return "#"+id+"("+((countDown>0)?countDown:"Liftoff!")+")";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
