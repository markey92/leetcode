package recursion;

/**
 * @ProjectName: leetcode
 * @Package: recursion
 * @ClassName: Recursion999
 * @Author: markey
 * @Description:
 * @Date: 2020/3/26 22:13
 * @Version: 1.0
 */
public class Recursion999 {
    public int numRookCaptures(char[][] board) {
        // 找出白色车的位置
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        // 向四个方向走看能不能碰到黑卒
        int[] xMove = new int[] {-1, 0, 1, 0};
        int[] yMove = new int[] {0, 1, 0, -1};
        int res = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1;; j++) {
                int xTemp = x + xMove[i] * j;
                int yTemp = y + yMove[i] * j;
                if (xTemp < 0 || xTemp >= 8 || yTemp < 0 || yTemp >= 8 || board[xTemp][yTemp] == 'B') {
                    break;
                }
                if (board[xTemp][yTemp] == 'p') {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
