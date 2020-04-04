package dynamicprogramming;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp304
 * @Author: markey
 * @Description:
 * @Date: 2020/3/22 21:44
 * @Version: 1.0
 */
public class Dp304 {
    class NumMatrix {

        int[][] matrix;
        int[][] dp;
        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            if (matrix.length > 0) {
                this.dp = new int[matrix.length][matrix[0].length];
                for (int i = 0; i < dp.length; i++) {
                    for (int j = 0; j < dp[i].length; j++) {
                        dp[i][j] = Integer.MIN_VALUE;
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            row1 = row1 - 1;
            col1 = col1 - 1;
            System.out.println();
            for (int i = 0; i < dp.length; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
            return sumRegion(row2, col2) + sumRegion(row1, col1) - sumRegion(row1, col2) - sumRegion(row2, col1);
        }

        private int sumRegion(int row, int col) {
            if (row <0 || col < 0) {
                return 0;
            }
            if (dp[row][col] != Integer.MIN_VALUE) {
                return dp[row][col];
            }
            int res = 0;
            for (int i = 0; i <= row; i++) {
                for (int j = 0; j <= col; j++) {
                    res += this.matrix[i][j];
                }
            }
            dp[row][col] = res;
            return res;
        }
    }
}
