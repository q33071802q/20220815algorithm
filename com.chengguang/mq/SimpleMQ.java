package mq;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleMQ {
    private static Queue<String> queue = new LinkedList<>();

    public void push(String item){
        queue.offer(item);
    }

    public String poll(){
        return queue.poll();
    }

    public String seek(){
        return queue.peek();
    }

    public static void main(String[] args) {
        SimpleMQ simpleMQ = new SimpleMQ();
        simpleMQ.push("a");
        simpleMQ.push("b");
        System.out.println(simpleMQ.seek());
        System.out.println(simpleMQ.poll());
        System.out.println(simpleMQ.seek());
    }
}
