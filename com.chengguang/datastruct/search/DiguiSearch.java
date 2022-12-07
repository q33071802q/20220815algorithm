package datastruct.search;

public class DiguiSearch {
    /**
     * 递归版本的二分查找
     */
    public static int bsearch(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private static int bsearchInternally(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return bsearchInternally(arr, mid + 1, high, value);
        } else {
            return bsearchInternally(arr, 0, mid - 1, value);
        }
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param arr
     * @param n
     * @param value
     * @return
     */
    public int bsearch2(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        /**
         * 难懂
         */
        if (low < n && arr[low] == value) {
            return low;
        } else {
            return -1;
        }
    }

    /**
     * 获取第一个匹配的数
     *
     * @param arr
     * @param n
     * @param value
     * @return
     */
    public int bsearch3(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                /*
                1.如果mid是第一个数 那必然是我们需要找到的数据
                2.如果mid的前一个数不是需要找的数据 那也是所匹配到的结果
                否则将高位往前移动
                 */
                if ((mid == 0) || arr[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    public int bsearch4(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid - 1;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                /*
                1.如果mid是第一个数 那必然是我们需要找到的数据
                2.如果mid的前一个数不是需要找的数据 那也是所匹配到的结果
                否则将高位往前移动
                 */
                if ((mid == n - 1) || arr[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    public int bsearch5(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                if ((mid==0)||arr[mid-1]<value){
                    return mid;
                }else {
                    high = mid-1;
                }
            } else  {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param
     */
    public int bsearch6(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] > value) {
                high = mid-1;
            } else  if (arr[mid]<=value){
                if ((mid==n-1)||arr[mid+1]!=value){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 2, 3,4, 6, 6, 6};
        System.out.println(new DiguiSearch().bsearch6(arr, 6, 6));
    }
}
