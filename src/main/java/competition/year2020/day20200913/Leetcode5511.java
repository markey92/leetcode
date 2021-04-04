package competition.year2020.day20200913;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200913
 * @ClassName: Leetcode5511
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 10:30
 * @Version: 1.0
 */
public class Leetcode5511 {
    public int numSpecial(int[][] mat) {
        int count = 0;
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 1 && check(mat, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(int[][] mat, int n, int m) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][m] == 1 && i != n) {
                return false;
            }
        }
        for (int i = 0; i < mat[n].length; i++) {
            if (mat[n][i] == 1 && i != m) {
                return false;
            }
        }
        return true;
    }
}
