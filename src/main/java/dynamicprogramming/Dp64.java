package dynamicprogramming;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp64
 * @Author: markey
 * @Description:
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:41
 * @Version: 1.0
 */
public class Dp64 {
    /**
     * Runtime: 2 ms, faster than 90.95% of Java online submissions for Minimum Path Sum.
     * Memory Usage: 42.4 MB, less than 79.73% of Java online submissions for Minimum Path Sum.
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        return res[m-1][n-1];
    }
}
