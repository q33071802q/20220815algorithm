package leetcode.array.search;

/**
 * leetcode 367 Valid prefect Square
 *
 * Given a positive integer num,return true if num is a prefect square or false otherwise.
 * A prefect square is an integer that is the square of an integer.In other words.it is the product of some integer with itself
 *
 * must not use any build-in library function.such as sqrt
 *
 * 这也太简单了吧 直接判断一个数是不是平方根
 */
public class PerfectSquare {

    public boolean isPerfectSquare(int num) {
        int i = 0;
        int j = num;
        while (i<=j){
            int middle = i+ ((j-i)>>1);
            if ((long)middle*middle == num){
                return true;
            }else if ((long)middle*middle<=num){
                i = middle+1;
            }else if ((long)middle*middle>=num){
                j = middle-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PerfectSquare perfectSquare = new PerfectSquare();
        System.out.println(perfectSquare.isPerfectSquare(16));
    }
}
