package com.markey.leetcode.one;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode130
 * @Author: markey
 * @Description:
 * @Date: 2021/7/13 21:05
 * @Version: 1.0
 */
public class Leetcode130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        solve(board, 0, 0, 0, n - 1);
        solve(board, m - 1, 0, m - 1, n - 1);
        solve(board, 1, 0, m - 2, 0);
        solve(board, 1, n - 1, m - 2, n - 1);
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void solve(char[][] board, int xStart, int xEnd, int yStart, int yEnd) {
        for (int i = xStart; i <= yStart; i++) {
            for (int j = xEnd; j <= yEnd; j++) {
                dfs(board, i, j);
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
            return;
        }
        if (board[x][y] == 'O') {
            board[x][y] = 'A';
            dfs(board, x - 1, y);
            dfs(board, x + 1, y);
            dfs(board, x, y - 1);
            dfs(board, x, y + 1);
        }
    }
}
