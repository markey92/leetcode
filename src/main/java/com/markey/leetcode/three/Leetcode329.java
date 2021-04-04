package com.markey.leetcode.three;

import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode329
 * @Author: markey
 * @Description:
 * @Date: 2020/7/26 20:00
 * @Version: 1.0
 */
public class Leetcode329 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] memo = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                res = Math.max(res, dfs(matrix, i, j, memo));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] > 0) {
            return memo[row][column];
        }
        memo[row][column] = 1;
        for(int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = column + dir[1];
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[newRow].length && matrix[newRow][newCol] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newCol, memo) + 1);
            }
        }
        return memo[row][column];
    }
}
