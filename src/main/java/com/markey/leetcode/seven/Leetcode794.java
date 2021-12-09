package com.markey.leetcode.seven;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.seven
 * @ClassName: Leetcode794
 * @Author: markey
 * @Description:
 * @Date: 2021/12/9 8:03
 * @Version: 1.0
 */
public class Leetcode794 {
    public boolean validTicTacToe(String[] board) {
        int numX = 0, numO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    numX++;
                }
                if (board[i].charAt(j) == 'O') {
                    numO++;
                }
            }
        }
        if (numX != numO && numX != numO + 1) return false;
        if (numX != numO + 1 && win(board, 'X')) return false;
        if (numX != numO && win(board, 'O')) return false;
        return true;
    }

    private boolean win(String[] board, char W) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == W && board[i].charAt(1) == W && board[i].charAt(2) == W) return true;
            if (board[0].charAt(i) == W && board[1].charAt(i) == W && board[2].charAt(i) == W) return true;
        }
        if (board[0].charAt(0) == W && board[1].charAt(1) == W && board[2].charAt(2) == W) return true;
        if (board[2].charAt(0) == W && board[1].charAt(1) == W && board[0].charAt(2) == W) return true;
        return false;
    }
}
