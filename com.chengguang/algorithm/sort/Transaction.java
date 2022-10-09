package algorithm.sort;

public class Transaction implements Comparable<Transaction> {
    private String str;
    public Transaction(String str) {
        this.str = str;
    }

    @Override
    public int compareTo(Transaction o) {
        return 0;
    }
}
