package thread;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 如何关闭异步线程
 */
public class CloseThread {

    public static class PrimeGenerator implements Runnable {

        private final List<BigInteger> primes = new ArrayList<>();

        /**
         * 利用volatile域来保存取消状态
         */
        private volatile boolean cancelled;

        @Override
        public void run() {
            BigInteger p = BigInteger.ONE;
            while (!cancelled) {
                p = p.nextProbablePrime();
                synchronized (this) {
                    primes.add(p);
                }
            }
        }

        public void cancel() {
            cancelled = true;
        }

        public synchronized List<BigInteger> get() {
            return new ArrayList<>(primes);
        }

        static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
            PrimeGenerator generator = new PrimeGenerator();
            new Thread(generator).start();
            try {
                Thread.sleep(10);
            } finally {
                generator.cancel();
            }
            return generator.get();
        }
    }

    class PrimeProduct extends Thread {
        private final BlockingQueue<BigInteger> queue;

        PrimeProduct(BlockingQueue<BigInteger> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                BigInteger p = BigInteger.ONE;
                while (!Thread.currentThread().isInterrupted()) {
                    queue.put(p = p.nextProbablePrime());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void cancel(){
            interrupt();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println(PrimeGenerator.aSecondOfPrimes());
    }
}
