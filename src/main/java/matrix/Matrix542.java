package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: matrix
 * @ClassName: Matrix542
 * @Author: markey
 * @Description:542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * 通过次数12,921提交次数33,807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/7 22:38
 * @Version: 1.0
 */
public class Matrix542 {
    public int[][] updateMatrix(int[][] matrix) {
        // 用队列保存需要计算最近距离的节点，如果某一节点的最近距离发生变化，则其周围四个节点需要重新计算
        Queue<int[]> queue = new LinkedList<>();
        // 队列的初始值就是所有为1的节点
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0], j = node[1];
            int min = getMinAround(matrix, i, j);
            if (min == matrix[i][j]) {
                // 最小值不变
                continue;
            }
            // 最小值变化，周围的四个节点需要重新计算
            matrix[i][j] = min;
            if (i - 1 >= 0) {
                queue.add(new int[] {i - 1, j});
            }
            if (j - 1 >= 0) {
                queue.add(new int[] {i, j - 1});
            }
            if (i + 1 < matrix.length) {
                queue.add(new int[] {i + 1, j});
            }
            if (j + 1 < matrix[i].length) {
                queue.add(new int[] {i, j + 1});
            }
        }
        return matrix;
    }

    private int getMinAround(int[][] matrix, int i, int j) {
        int min = Integer.MAX_VALUE;
        if (i - 1 >= 0 && matrix[i-1][j] + 1 < min) {
            min = matrix[i-1][j] + 1;
        }
        if (j - 1 >= 0 && matrix[i][j-1] + 1< min) {
            min = matrix[i][j-1] + 1;
        }
        if (i + 1 < matrix.length && matrix[i+1][j] + 1 < min) {
            min = matrix[i+1][j] + 1;
        }
        if (j + 1 < matrix[i].length && matrix[i][j+1] + 1 < min) {
            min = matrix[i][j+1] + 1;
        }
        return min;
    }
}
