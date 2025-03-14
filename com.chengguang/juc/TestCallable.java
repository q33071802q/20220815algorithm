package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemo td = new ThreadDemo();

        FutureTask<Integer> result = new FutureTask<>(td);

        new Thread(result).start();

        System.out.println("--------");

        Integer integer = result.get();
        System.out.println(integer);
    }
}

class ThreadDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum+=1;
        }
        return sum;
    }
}
