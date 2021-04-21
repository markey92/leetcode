package com.markey.leetcode.three;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode363
 * @Author: markey
 * @Description:
 * @Date: 2021/4/22 7:41
 * @Version: 1.0
 */
public class Leetcode363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // 暴力遍历
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] preSum = new int[n + 1][m + 1]; // 前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] = matrix[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l <= i; l++) {
                    for (int o = 0; o <= j; o++) {
                        int sum = preSum[i + 1][j + 1] - preSum[i + 1][o] - preSum[l][j  + 1] + preSum[l][o];
                        if (sum <= k) {
                            max = Math.max(max, sum);
                            System.out.println(i + " " + j + " " + l + " " + o + " " + sum);
                        }
                    }
                }
            }
        }
        return max;
    }
}
