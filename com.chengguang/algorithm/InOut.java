package algorithm;

import algorithm.sort.StdOut;

import java.util.HashMap;
import java.util.Map;

import static algorithm.sort.StdOut.printf;

/**
 * > 输出重定向文件
 * < 以某某文件作为程序输入
 * 管道 某某程序输出作为某某程序输入
 */
public class InOut {
    public static class Test06 {

        public static void main(String[] args) {
            rank(10,new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});
        }
        public static int rank(int key, int[] a) {
            return rank(key, a, 0, a.length - 1,1);
        }

        public static int rank(int key, int[] a, int lo, int hi,int deep) {
            if (lo > hi) {
                return -1;
            }
            int mid = lo + (hi - lo) / 2;
            for (int i = 0; i < deep; i++) {
                System.out.println(" ");
            }
            if (key < a[mid]) {
                return rank(key, a, lo, mid - 1,deep+1);
            }else if (key>a[mid]){
                return rank(key,a,mid+1,hi,deep+1);
            }else {
                System.out.println("deep:"+deep);
                return mid;
            }
        }

        public static int rank(int key, int[] a, int lo, int hi) {
            if (lo > hi) {
                return -1;
            }
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                return rank(key, a, lo, mid - 1);
            }else if (key>a[mid]){
                return rank(key,a,mid+1,hi);
            }else {
                return mid;
            }
        }
    }

    public static class Test05 {
        public static void main(String[] args) {
            System.out.println(lnN(10d));
        }

        public static double lnN(double n) {
            if (n == 1) return 0;
            return Math.log(n) + lnN(n - 1);
        }
    }

    public static class Test04 {
        static Map<Integer, Long> resultMap = new HashMap<>();

        public static void main(String[] args) {
            for (int i = 0; i < 100; i++) {
                long f = F(i);
                resultMap.put(i, f);
                System.out.println(i + "`" + f);
            }
        }

        public static long F(int N) {
            if (resultMap.containsKey(N)) {
                return resultMap.get(N);
            }
            if (N == 0) return 0;
            if (N == 1) return 1;
            return F(N - 1) + F(N - 2);
        }
    }

    /**
     * 所谓递归 不过分支而已
     */
    public static class Test03 {
        public static void main(String[] args) {
//            System.out.println(mystery(2,25));
            System.out.println(mystery(3, 11));
        }

        public static int mystery(int a, int b) {
            if (b == 0) return 0;
            if (b % 2 == 0) return mystery(a + a, b + b);
            System.out.println(a + "`" + b);
            return mystery(a + a, b / 2) + a;
        }
    }

    public static class Test02 {
        // stackoverflow
        public static void main(String[] args) {
            System.out.println(exR2(6));
        }

        public static String exR2(int n) {
            String s = exR2(n - 3) + n + exR2(n - 2) + n;
            if (n <= 0) return "";
            return s;
        }
    }

    public static class Test01 {
        public static void main(String[] args) {
            System.out.println(exR1(6));
        }


        public static String exR1(int n) {
            if (n <= 0) return "";
            return exR1(n - 3) + n + exR1(n - 2) + n;
        }
    }


}
