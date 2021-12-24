package com.markey.leetcode.four;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.four
 * @ClassName: Leetcode419
 * @Author: markey
 * @Description:
 * @Date: 2021/12/18 21:21
 * @Version: 1.0
 */
public class Leetcode419 {
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && !(i - 1 >= 0 && board[i - 1][j] == 'X' || j - 1 >= 0 && board[i][j - 1] == 'X')) {
                    res++;
                }
            }
        }
        return res;
    }
}
