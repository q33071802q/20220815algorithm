package datastruct.back;

/**
 * 回溯算法
 */
public class Queen {
    /**
     * 八皇后问题
     * <p>
     * 下标表示行 值表示存储在哪一列
     */
    private static int[] result = new int[8];

    public void cal8Queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; ++column) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8Queens(row + 1);
            }
        }
    }

    /**
     * 判断row行column列放置是否合适
     * 代码有点难理解 得画图
     *
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column) {
        int leftUp = column - 1; //左上角
        int rightUp = column + 1; //右上角
        //逐行向上考察每一行
        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == column) {
                //说明i行是有棋子的
                return false;
            }
            if (leftUp >= 0) {
                if (result[i] == leftUp) {
                    //说明左上角有棋子
                    return false;
                }
            }
            if (rightUp < 8) {
                if (result[i] == rightUp) {
                    //说明右上角有棋子
                    return false;
                }
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Queen().cal8Queens(1);
    }

}
