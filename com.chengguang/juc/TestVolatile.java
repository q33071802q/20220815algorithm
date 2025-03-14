package juc;

public class TestVolatile {
    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        new Thread(testDemo).start();

        while (true) {
            System.out.println("current:" + testDemo.isFlag());
            if (testDemo.isFlag()) {
                System.out.println("-----");
                break;
            }
        }
    }
}

class TestDemo implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        flag = true;

        System.out.println("flag:" + isFlag());

    }

    public boolean isFlag() {
        return flag;
    }
}
