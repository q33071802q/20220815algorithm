package algorithm.sort;

public class TopM {
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
        while (StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size()>M){
                pq.delMax();
            }
        }
    }
}

class MinPQ<T extends Comparable<T>>{
    private T MAX;
    public MinPQ(int length) {
    }

    public void insert(T t){

    }

    public T max(){
        return MAX;
    }

    public T delMax(){
        return MAX;
    }

    public boolean isEmpty(){
        return false;
    }

    public int size(){
        return 0;
    }


}
