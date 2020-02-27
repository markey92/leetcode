package lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF29
 * @Author: markey
 * @Description:面试题29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/27 22:58
 * @Version: 1.0
 */
public class LCOF29 {

    /**
     * 旋转导致执行效率很低执行用时 :19 ms, 在所有 Java 提交中击败了5.03%的用户
     * 内存消耗 :42.3 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        while (matrix.length > 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                res.add(matrix[0][i]);
            }
            matrix = spin(matrix);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 旋转矩阵，
     * 1 2 3
     * 4 5 6
     * 变成
     * 3，6，
     * 2，5
     * 1，4
     * @param matrix
     * @return
     */
    private int[][] spin(int[][] matrix) {
        int col = matrix[0].length, row = matrix.length;
        int[][] res = new int[col][row - 1];
        for (int i = 0; i < col; i++) {
            for (int j = 1; j < row; j++) {
                res[i][j - 1] = matrix[j][col - 1 -i];
            }
        }
        return res;
    }
}
