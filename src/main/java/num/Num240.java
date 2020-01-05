package num;

/**
 * @ProjectName: leetcode
 * @Package: num
 * @ClassName: Num240
 * @Author: markey
 * @Description:
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/5 21:56
 * @Version: 1.0
 */
public class Num240 {

    public static void main(String[] args) {
        int [][] input2 = new int[][] {{1}};
        int[][] input = new int[][] {{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix3(input, 5));
    }

    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了99.12%的用户
     * 内存消耗 :42.7 MB, 在所有 Java 提交中击败了97.30%的用户
     */
    public static boolean searchMatrix3(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1;
        int y = 0;
        while (x >= 0 && y < col) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int posX = 0;
        int posY = col - 1;
        //从右上角往左下角找
        while (posX < row && posY >= 0) {
            if (matrix[posX][posY] == target) {
                return true;
            }
            if (matrix[posX][posY] > target) {
                posY--;
            } else {
                posX++;
            }
        }
        return false;
    }
    /**
     * 从上往下搜索每一行，如果这一行的最左边（第一个）大于目标数或者最右边（最后一个）小于目标
     * 则说明不在这一行，直接搜寻下一行
     * 执行用时 :10 ms, 在所有 Java 提交中击败了85.33%的用户
     * 内存消耗 :42.5 MB, 在所有 Java 提交中击败了98.47%的用户
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
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
                        break;
                    }
                }
            }
        }
        return false;
    }
}
