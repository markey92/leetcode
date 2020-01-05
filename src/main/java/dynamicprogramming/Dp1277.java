package dynamicprogramming;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp1277
 * @Author: markey
 * @Description:
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 *
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:44
 * @Version: 1.0
 */
public class Dp1277 {
    /**
     * Runtime: 9 ms, faster than 44.14% of Java online submissions for Count Square Submatrices with All Ones.
     * Memory Usage: 61.9 MB, less than 100.00% of Java online submissions for Count Square Submatrices with All Ones.
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        res[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            res[i][0] = res[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            res[0][i] = res[0][i- 1] + matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1] - res[i-1][j-1]
                        + countSquaresInX(matrix, i, j);
            }
        }
        return res[matrix.length - 1][matrix[0].length - 1];
    }

    private int countSquaresInX(int[][] matrix, int m, int n) {
        if (matrix[m][n] == 0) {
            return 0;
        }
        int maxSize = Math.min(m, n);
        int count = 1;
        for (int i = 1; i <= maxSize; i++) {
            for (int j = 0; j <= i; j++) {
                if (matrix[m - j][n - i] == 0 || matrix[m - i][n - j] == 0) {
                    return count;
                }
            }
            count++;
        }
        return count;
    }
}
