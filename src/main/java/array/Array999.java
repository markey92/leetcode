package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array999
 * @Author: markey
 * @Description:
 * @Date: 2019/10/17 22:23
 * @Version: 1.0
 */
public class Array999 {

    public int numRookCaptures(char[][] board) {
        int iRook = 0;
        int jRook = 0;
        boolean findRook = false;
        for (int i = 0; i < board.length && !findRook; i++) {
            for (int j = 0; j < board[i].length && !findRook; j++) {
                if (board[i][j] == 'R') {
                    findRook = true;
                    iRook = i;
                    jRook = j;
                    break;
                }
            }
        }
        System.out.println(iRook);
        int count = 0;
        for (int j = jRook + 1; j < board[iRook].length; j++) {
            if (board[iRook][j] == '.') {
                continue;
            }
            if (board[iRook][j] == 'p') {
                count++;
            }
            break;
        }
        for (int j = jRook - 1; j >= 0; j--) {
            if (board[iRook][j] == '.') {
                continue;
            }
            if (board[iRook][j] == 'p') {
                count++;
            }
            break;
        }
        for (int i = iRook - 1; i >= 0; i--) {
            if (board[i][jRook] == '.') {
                continue;
            }
            if (board[i][jRook] == 'p') {
                count++;
            }
            break;
        }
        for (int i = iRook + 1; i < board.length; i++) {
            if (board[i][jRook] == '.') {
                continue;
            }
            if (board[i][jRook] == 'p') {
                count++;
            }
            break;
        }
        return count;
    }
}
