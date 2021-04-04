package competition.year2020.day20200705;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200705
 * @ClassName: Matrix5454
 * @Author: markey
 * @Description:
 * @Date: 2020/7/5 10:37
 * @Version: 1.0
 */
public class Matrix5454 {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int all = m * n;
        boolean[][] dp = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < all; i++) {
            int x1 = i % n;
            int y1 = i / n;
            for (int j = x1; j < n; j++) {
                for (int k = y1; k < m; k++) {
                    if (mat[k][j] == 0) {
                        dp[k][j] = false;
                        continue;
                    }
                    if (j > x1 && dp[k][j - 1] == false) {
                        dp[k][j] = false;
                        continue;
                    }
                    if (k > y1 && dp[k-1][j] == false) {
                        dp[k][j] = false;
                        continue;
                    }
                    dp[k][j] = true;
                    count += 1;
                }
            }
        }
        return count;
    }
}
