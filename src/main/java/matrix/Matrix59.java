package matrix;

/**
 * @ProjectName: leetcode
 * @Package: matrix
 * @ClassName: Matrix59
 * @Author: markey
 * @Description:59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/4 10:00
 * @Version: 1.0
 */
public class Matrix59 {
    public int[][] generateMatrix(int n) {
        // 用0123来表示方向
        int[] row = new int[] {0, 1, 0, -1};
        int[] col = new int[] {1, 0, -1, 0};
        int[][] res = new int[n][n];
        int direction = 0;
        int rowIndex = 0, colIndex = 0;
        for (int i = 1; i <= n * n; i++) {
            System.out.println(rowIndex + " " + colIndex);
            res[rowIndex][colIndex] = i;
            // 需要 改变方向的情况
            if (rowIndex + row[direction] >= n || rowIndex + row[direction] < 0) {
                direction = (direction + 1) % 4;
            } else if (colIndex + col[direction] >= n || colIndex + col[direction] < 0) {
                direction = (direction + 1) % 4;
            } else if (res[rowIndex + row[direction]][colIndex + col[direction]] != 0) {
                direction = (direction + 1) % 4;
            } else {
                // 不用改变方向
            }
            rowIndex += row[direction];
            colIndex += col[direction];
        }
        return res;
    }
}
