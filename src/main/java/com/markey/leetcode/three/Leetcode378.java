package com.markey.leetcode.three;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode378
 * @Author: markey
 * @Description:
 * @Date: 2021/3/21 21:49
 * @Version: 1.0
 */
public class Leetcode378 {
    // 二分法，夹逼原则使得结果必定在矩阵内

    /**
     * 假设结果是target
     * 因为只有count(matrix, mid) < k的情况下才有left = mid + 1
     * 所以必然存在[start, target - 1]都不符合要求；[target, end]符合要求
     * target是第一个符合要求的数字，所以target必然在矩阵内；
     */
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length; // 行数
        int col = matrix[0].length; // 列数
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(matrix, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 时间复杂度是n，求出小于等于x的个数
    public int count(int[][] matrix, int x) {
        int res = 0;
        int index = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            int[] row = matrix[i];
            while (index < row.length && row[index] <= x) {
                index++;
            }
            res += index;
        }
        return res;
    }
}
