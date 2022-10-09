package algorithm.sort;

import java.util.*;

public class Print {
    public static void main(String[] args) {
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    public static class Inner {
        public static void main(String[] args) {
            int sum = 0;
            for (int i = 1; i < 1000; i *= 2) {
                for (int j = 0; j < 1000; j++) {
                    sum++;
                }
            }
            System.out.println(sum);
        }

        public static class Inner2 {
            public static void main(String[] args) {
                int sum = 0;
                for (int i = 1; i < 1000; i++) {
                    for (int j = 0; j < i; j++) {
                        sum++;
                    }
                    System.out.println(sum);
                }
                System.out.println(sum);
            }
        }

        public static class Inner3 {
            public static void main(String[] args) {
                boolean[][] arr = {{true, false, true}, {false, true, false}, {true, false, true}};
                printBooleanMatrix(arr);
            }

            private static void printBooleanMatrix(boolean[][] matrix) {
                for (int i = 0; i < matrix.length; i++) {
                    System.out.print(i + 1 + " ");
                    for (int j = 0; j < matrix.length; j++) {
                        System.out.print(matrix[i][j] ? "*" : " ");
                    }
                    System.out.println();
                }
            }
        }

        public static class Inner4 {
            public static void main(String[] args) {
                int[] arr = new int[10];
                for (int i = 0; i < 10; i++) {
                    arr[i] = 9 - i;
                }
                System.out.println(Arrays.toString(arr));
                for (int i = 0; i < 10; i++) {
                    arr[i] = arr[arr[i]];
                }
                System.out.println(Arrays.toString(arr));
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        }

        public static class Inner5 {
            public static void main(String[] args) {
                int[][] arr = new int[10][10];
                for (int i = 0; i < arr[i].length - 1; i++) {
                    for (int j = 0; j < arr[j].length - 1; j++) {
                        arr[i][j] = j;
                    }
                }
                System.out.println(Arrays.deepToString(arr));
                System.out.println(Arrays.deepToString(reverseArray(arr)));

            }

            private static int[][] reverseArray(int[][] arr) {
                int[][] b = new int[10][10];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        b[j][i] = arr[i][j];
                    }
                }
                return b;
            }

        }

        public static class Inner6 {
            public static void main(String[] args) {
                System.out.println(lg2(8));
            }

            public static int lg2(int n) {
                int i = 1;
                int result = 1;
                int count = 0;
                while (result < n) {
                    for (int j = 0; j < n; j++) {
                        result *= 2;
                        count++;
                        if (result > n) {
                            count--;
                            break;
                        }
                    }
                    System.out.println("fsa:" + result);
                    System.out.println("ffsafsa:" + count);
                }
                return count;
            }
        }

        public static class Inner7 {
            public static void main(String[] args) {
                System.out.println(exR1(6));
            }

            public static String exR1(int n) {
                if (n <= 0) {
                    return "";
                }
                String s = exR1(n - 3) + n + exR1(n - 2) + n;
                return s;
            }
        }

        public static class Inner8 {
            public static void main(String[] args) {
                System.out.println(exR2(6));
            }

            public static String exR2(int n) {
                String s = exR2(n - 3) + n + exR2(n - 2) + n;
                if (n <= 0) return "";
                return s;
            }
        }

        public static class Inner9 {
            public static void main(String[] args) {
                System.out.println(mystery(3, 4));
                System.out.println(Math.pow(3, 4));
            }

            public static int mystery(int a, int b) {
                if (b == 0) return 1;
                if (b % 2 == 0) return mystery(a * a, b / 2);
                return mystery(a * a, b / 2) * a;
            }
        }

        public static class Inner10 {
            public static void main(String[] args) {
                long l = System.currentTimeMillis();
                for (int i = 0; i < 40; i++) {
                    System.out.println(i + "" + F(i));
                }
                System.out.println("时间：" + (System.currentTimeMillis() - l));
            }

            public static long F(int N) {
                long[] res = new long[N + 1];
                if (N == 0) return res[0];
                res[1] = 1;
                if (N == 1) return res[1];
                for (int i = 2; i <= N; i++) {
                    res[i] = res[i - 1] + res[i - 2];
                }
                return res[N];
            }
        }

        public static class Inner11 {
            public static void main(String[] args) {
                System.out.println(ln(4));
            }

            public static double ln(double n) {
                if (n == 1.0) return 0.0;
                double v = Math.log(n) + ln(n - 1);
                return v;
            }
        }

        public static class Inner12 {
            public static void main(String[] args) {
                System.out.println("请输入次数");
                Scanner scanner = new Scanner(System.in);
                int n = scanner.nextInt();
                extracted(n);
            }

            private static void extracted(int n) {
                Scanner scanner = new Scanner(System.in);
                String[] nameArray = new String[n];
                int[] intArray1 = new int[n];
                int[] intArray2 = new int[n];
                for (int i = 0; i < n; i++) {
                    nameArray[i] = scanner.nextLine();
                    intArray1[i] = scanner.nextInt();
                    intArray2[i] = scanner.nextInt();
                }
                System.out.println("name 工资 税后 净得");
                for (int i = 0; i < n; i++) {
                    System.out.printf("%2s,%-3d,%-3d,%.3f", nameArray[i], intArray1[i], intArray2[i], 1.0 * intArray2[i] / (1.0 * intArray1[i]));
                }
            }
        }

        public static class Inner13 {
            public static void main(String[] args) {
                int N = 1024;
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = new Random().nextInt(5);
                }
                Arrays.sort(arr);
                for (int i = 0; i < N; i++) {
                    System.out.println(arr[i] + "\t");
                }
                int index = new Random().nextInt(arr.length);
                System.out.println("index:" + index);
                System.out.println("key:" + arr[index]);
                int key = arr[index];
                System.out.println(binarySearch(key, arr, 0));
            }

            private static int binarySearch(int key, int[] arr, int depth) {
                return rank(key, arr, 0, arr.length - 1, depth);
            }


            private static int rank(int key, int[] arr, int low, int high, int depth) {
                printCallInfo(low, high, depth);
                if (low > high) {
                    return -1;
                }
                int mid = low + (high - low) / 2;
                if (key < arr[mid]) {
                    return rank(key, arr, low, mid - 1, depth + 1);
                } else if (key > arr[mid]) {
                    return rank(key, arr, mid + 1, high, depth + 1);
                } else {
                    return mid;
                }
            }

            private static void printCallInfo(int low, int high, int depth) {
                System.out.println("深度：" + depth + "\t");
                printIndent(depth);
                System.out.println(low + "\t");
            }

            private static void printIndent(int indents) {
                for (int i = 0; i < indents; i++) {
                    System.out.println("------");
                }
            }
        }

        public static class Inner14 {
            public static void main(String[] args) {
                int[] whitelist = new int[]{1, 2, 3};
                Arrays.sort(whitelist);
                System.out.println(BinaryLookup(2, whitelist));

            }
        }

        public static class Evaluate {
            public static void main(String[] args) {
                Stack<String> ops = new Stack<>();
                Stack<Double> vals = new Stack<>();
                while (!StdIn.isEmpty()) {
                    String s = StdIn.readString();
                    if (s.equals("(")) {
                    } else if (s.equals("+")) {
                        ops.push(s);
                    } else if (s.equals("-")) {
                        ops.push(s);
                    } else if (s.equals("*")) {
                        ops.push(s);
                    } else if (s.equals("/")) {
                        ops.push(s);
                    } else if (s.equals("sqrt")) {
                        ops.push(s);
                    } else if (s.equals(")")) {
                        String op = ops.pop();
                        Double v = vals.pop();
                        if (op.equals("+")) {
                            v = vals.pop() + v;
                        } else if (op.equals("-")) {
                            v = vals.pop() - v;
                        } else if (op.equals("*")) {
                            v = vals.pop() * v;
                        } else if (op.equals("/")) {
                            v = vals.pop() / v;
                        } else if (op.equals("sqrt")) {
                            v = Math.sqrt(v);
                        }
                        vals.push(v);
                    } else {
                        vals.push(Double.parseDouble(s));
                    }
                }
                StdOut.println(vals.pop());
            }
        }

        public static class ResizingArrayStack<Item> implements Iterable<Item> {

            private Item[] a = (Item[]) new Object[1];
            private int N = 0;

            public boolean isEmpty() {
                return N == 0;
            }

            public int size() {
                return N;
            }

            private void resize(int max) {
                Item[] temp = (Item[]) new Object[max];
                for (int i = 0; i < a.length; i++) {
                    temp[i] = a[i];
                }
                a = temp;
            }

            public void push(Item item) {
                if (N == a.length) {
                    resize(2 * a.length);
                }
                a[N++] = item;
            }

            public Item pop() {
                Item item = a[--N];
                a[N] = null;
                if (N > 0 && N == a.length / 4) {
                    resize(a.length / 2);
                }
                return item;
            }

            @Override
            public Iterator<Item> iterator() {
                return new ReverseArrayIterator();
            }

            private class ReverseArrayIterator implements Iterator<Item> {

                private int i = N;

                @Override
                public boolean hasNext() {
                    return i > 0;
                }

                @Override
                public Item next() {
                    return a[--i];
                }

            }
        }

        public static int BinaryLookup(int key, int[] arr) {
            int low = 0;
            int high = arr.length - 1;
            int mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (key < arr[mid]) {
                    high = mid - 1;
                } else if (key > arr[mid]) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
            if (low > high) {
                return -1;
            }
            return mid;
        }
    }
}

class Node {
    String item;
    Node next;
}
