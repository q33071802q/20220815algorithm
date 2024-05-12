package thinkjava.thread;

class FibonacciA3 implements Runnable{

    private int n = 0;

    public FibonacciA3(int n) {
        this.n = n;
    }

    private int fib(int n){
        if (n<2) return 1;
        return fib(n-2)+fib(n-1);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(fib(i)+" ");
        }
    }
}

class FibonacciB3 implements Runnable{

    private int n = 0;

    public FibonacciB3(int n) {
        this.n = n;
    }

    private int fib(int n){
        if (n<2) return 1;
        return fib(n-2)+fib(n-1);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(fib(i)+" ");
        }
    }
}


class FibonacciC3 implements Runnable{

    private int n = 0;

    public FibonacciC3(int n) {
        this.n = n;
    }

    private int fib(int n){
        if (n<2) return 1;
        return fib(n-2)+fib(n-1);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(fib(i)+" ");
        }
    }
}


class FibonacciD4 implements Runnable{

    private int n = 0;

    public FibonacciD4(int n) {
        this.n = n;
    }

    private int fib(int n){
        if (n<2) return 1;
        return fib(n-2)+fib(n-1);
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(fib(i)+" ");
        }
    }
}

public class Ex3 {
    public static void main(String[] args) {
        Thread f1 = new Thread(new FibonacciA3(15));
        Thread f2 = new Thread(new FibonacciB3(15));
        Thread f3 = new Thread(new FibonacciC(15));
        Thread f4 = new Thread(new FibonacciD(15));
        f1.start();
        f2.start();
        f3.start();
        f4.start();
    }
}

