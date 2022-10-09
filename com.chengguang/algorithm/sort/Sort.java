package algorithm.sort;

/**
 * 排序类模板
 * <p>
 * 双层循环一般思想 第一个循环拿到每张 然后 将这张与剩下的操作
 *
 * @author hechen
 */
public class Sort {

    /**
     * 选择排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
//        selectSort(a);
//        insertSort(a);
        shellSort(a);
    }



    /**
     * h的意义在于 把一个数组中的数按h进行分割 然后把相隔h的元素进行排序
     * 希尔排序 思想 在插入排序的基础上改进
     * 交换不相邻的元素以对数组局部进行排序
     * 有个好处 根据数组规模进行处理问题 在大量的数面前就不用一开始一个个相邻的比较了 浪费性能
     * 1.按h分组
     * 2.将分组后的数据按h一轮轮进行排序 每轮排序完除以分组的规模h 直到间隔h为1的时候排序完毕
     *
     * @param a
     */
    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1; //1.4.13.40
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    /**
     * 插入排序 人们在玩桥牌的时候 会将每张插入到已经有序的牌中
     *
     * @param a
     */
    public static void insertSort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * 精髓在于 不断地选择范围内的最小值放到范围内的最前面位置
     *
     * @param a
     */
    private static void selectSort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //默认第一个是最小的数
            int min = i;
            //将后面的数依次与第一个数比较 如果比前者小 则最小数重置 目的是找到每一轮最小的数放到最前面
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    /***
     * 对元素进行比较
     * @param v
     * @param w
     * @return
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 元素交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 输出元素
     *
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 判断是否已经排序完
     *
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = new In("tiny.txt").readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }


}

