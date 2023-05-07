package leetcode.array.sum;

import java.util.Arrays;

/**
 * Given a positive integer n,generate an n*n matrix
 * filled with elements from 1 to n^2 in spiral order.
 *
 * 上下左右 四条边 上 1->n 右n->
 *
 * n代表每条边的个数 n
 */
public class SpiralMatrix {
    public int[][] generateMatrix(int n){
        int i = 0;
        int j = 0;

//        int[][] arr = new int[n][n];
//
//        arr[0][0] = 1;
//
//        int[][] arr = new int[n][n];
//
//        arr[0][0] = 1;
//        arr[0][1] = 2;
//        arr[1][1] = 3;
//        arr[1][0] = 4;

//        int[][] arr = new int[n][n];
//
//        arr[0][0] = 1;
//        arr[0][1] = 2;
//        arr[0][2] = 3;
//        arr[1][2] = 4;
//        arr[2][2] = 5;
//        arr[2][1] = 6;
//        arr[2][0] = 7;
//        arr[1][0] = 8;
//        arr[1][1] = 9;


        int[][] arr = new int[n][n];

        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[0][2] = 3;
        arr[0][3] = 4;
        arr[1][3] = 5;
        arr[2][3] = 6;
        arr[3][3] = 7;
        arr[3][2] = 8;
        arr[3][1] = 9;
        arr[3][0] = 10;
        arr[2][0] = 11;
        arr[1][0] = 12;
        arr[1][1] = 13;
        arr[1][2] = 14;
        arr[2][2] = 15;
        arr[2][1] = 16;





        return arr;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(Arrays.deepToString(spiralMatrix.generateMatrix(4)));
    }
}
