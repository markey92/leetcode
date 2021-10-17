package competition.year2021.day20210711;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210711
 * @ClassName: Leetcode5811
 * @Author: markey
 * @Description:
 * @Date: 2021/7/11 10:43
 * @Version: 1.0
 */
public class Leetcode5811 {
    public int colorTheGrid(int m, int n) {
        long[][][] dp = new long[m][n][3];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        dp[0][0][2] = 1;
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = dp[0][j - 1][1] + dp[0][j - 1][2];
            dp[0][j][1] = dp[0][j - 1][0] + dp[0][j - 1][2];
            dp[0][j][2] = dp[0][j - 1][0] + dp[0][j - 1][1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i - 1][0][1] + dp[i - 1][0][2];
            dp[i][0][1] = dp[i - 1][0][0] + dp[i - 1][0][2];
            dp[i][0][2] = dp[i - 1][0][0] + dp[i - 1][0][1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][0] = (dp[i - 1][j][1] + dp[i - 1][j][2]) * (dp[i][j - 1][1] + dp[i][j - 1][2]);
                dp[i][j][1] = (dp[i - 1][j][0] + dp[i - 1][j][2]) * (dp[i][j - 1][0] + dp[i][j - 1][2]);
                dp[i][j][2] = (dp[i - 1][j][0] + dp[i - 1][j][0]) * (dp[i][j - 1][0] + dp[i][j - 1][1]);
            }
        }
        return (int) ((dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1] + dp[m - 1][n - 1][2]) % 1_000_000_007);
    }
}
