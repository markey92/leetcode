package CrackingTheCodingInterview;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode10_09
 * @Author: markey
 * @Description:
 * @Date: 2020/10/28 21:41
 * @Version: 1.0
 */
public class Leetcode10_09 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从左下角开始查找
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[row].length) {
            if (target > matrix[row][col]) {
                col++;
            } else if (target < matrix[row][col]) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
