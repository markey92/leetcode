package test.test20211204;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: test.test20211204
 * @ClassName: Test1
 * @Author: markey
 * @Description:
 * @Date: 2021/12/4 21:07
 * @Version: 1.0
 */
public class Test1 {
    public int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[d][target + 1];
        for (int i = 1; i <= target; i++) {
            if (i <= f) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][Math.max(j - k, 0)]) % 1_000_000_007;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return (int) (dp[d - 1][target] % 1_000_000_007);
    }
}
