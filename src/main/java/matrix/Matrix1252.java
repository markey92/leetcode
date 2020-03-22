package matrix;

/**
 * @ProjectName: leetcode
 * @Package: matrix
 * @ClassName: Matrix1252
 * @Author: markey
 * @Description:1252. 奇数值单元格的数目
 * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 *
 * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 *
 * 示例 1：
 *
 * 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/13 23:28
 * @Version: 1.0
 */
public class Matrix1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];

        for (int i = 0; i < indices.length; i++) {
            int[] index = indices[i];
            for (int j = 0; j < n; j++) {
                matrix[j][index[1]] ++;
            }
            for (int j = 0; j < m; j++) {
                matrix[index[0]][j] ++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
