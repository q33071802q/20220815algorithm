package algorithm.sort;

class QuickTest {
    public static void main(String[] args) {
        String[] a = new In("tiny.txt").readAllStrings();
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        int mid = hi - lo / 2 + lo;
        int i = lo;
        int j = mid + 1;
        sort(a, i++, mid);
    }

}