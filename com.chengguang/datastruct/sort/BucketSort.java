package datastruct.sort;

/**
 * 将要排序得数据分到几个有序的桶里
 * 每个桶里的数据再单独进行排序
 * 桶内排完序后，再把每个桶里的数据按照顺序
 * 以次取出，组成的序列就是有序的了
 * <p>
 * 得看视频
 */
public class BucketSort {
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length < 2) {
            return;
        }

        //获取数组中最大最小值
        int minValue = arr[0];
        int maxValue = arr[1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            } else if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        //按桶的大小分出桶的个数
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];

        //将数组中值分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            //根据数值找到这个数应该存放到哪个桶
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            //数组满了 扩容
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensureCapacity(buckets, bucketIndex);
            }
            //将数值放到对应的桶中 再把对应桶里的索引位置+1
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }

        //对每个桶进行排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            quickSortC(buckets[i], 0, indexArr[i] - 1);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }


    private static void quickSortC(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);
        quickSortC(arr, 0, q - 1);
        quickSortC(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j]<=pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }

    private static void swap(int[] arr,int i,int j){
        if (i==j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 数组扩容
     * @param buckets
     * @param bucketIndex
     */
    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length*2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }
}
