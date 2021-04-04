package competition.year2020.day20200905;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200905
 * @ClassName: Leetcode5491
 * @Author: markey
 * @Description:
 * @Date: 2020/9/5 22:30
 * @Version: 1.0
 */
public class Leetcode5491 {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            res += mat[i][i];
            res += mat[i][n - 1 - i];
            if (n - 1 == i * 2) {
                res -= mat[i][i];
            }
        }
        return res;
    }
}
