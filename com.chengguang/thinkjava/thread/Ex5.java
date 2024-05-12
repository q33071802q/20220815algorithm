package thinkjava.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Ex5Fibonacci implements Callable<String> {
    private int n = 0;

    public Ex5Fibonacci(int n) {
        this.n = n;
    }
    private int fib(int x){
        if (x<2) return 1;
        return fib(x-2)+fib(x-1);
    }

    @Override
    public String call()  {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result+=fib(i);
        }
        return n+"-"+result;
    }
}

public class Ex5{
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            results.add(exec.submit(new Ex5Fibonacci(i)));
        }
        for (Future<String> fs : results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
