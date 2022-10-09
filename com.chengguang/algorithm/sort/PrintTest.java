package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Random().nextInt(5);
        }
        System.out.println(Arrays.toString(arr));
        int index = new Random().nextInt(arr.length);
        System.out.println(arr[index]);
    }

}