package CrackingTheCodingInterview;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode01_08
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 18:03
 * @Version: 1.0
 */
public class Leetcode01_08 {
    public void setZeroes(int[][] matrix) {
        boolean[] zeroRow = new boolean[matrix.length];
        boolean[] zeroCol = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (zeroRow[i] || zeroCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
