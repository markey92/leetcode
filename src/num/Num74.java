package num;

/**
 * @ProjectName: leetcode
 * @Package: num
 * @ClassName: Num74
 * @Author: markey
 * @Description:
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/5 21:23
 * @Version: 1.0
 */
public class Num74 {

    public static void main(String[] args) {
        int [][] input2 = new int[][] {{1}};
        int[][] input = new int[][] {{1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}};
        System.out.println(searchMatrix(input2, 13));
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了61.04%的用户
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int y = 0;
        while (y < matrix.length && matrix[y][matrix[y].length - 1] < target) {
            y++;
        }
        for (int i = 0; y < matrix.length && i < matrix[y].length; i++) {
            if (matrix[y][i] < target) {
                continue;
            }
            if (matrix[y][i] == target) {
                return true;
            }
            if (matrix[y][i] > target) {
                return false;
            }
        }
        return false;
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :42.5 MB, 在所有 Java 提交中击败了39.86%的用户
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length - 1] >= target && matrix[i][0] <= target) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] < target) {
                        continue;
                    }
                    if (matrix[i][j] == target) {
                        return true;
                    }
                    if (matrix[i][j] > target) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
