package interview.day20210421;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20210421
 * @ClassName: Test3
 * @Author: markey
 * @Description:
 * @Date: 2021/4/21 20:35
 * @Version: 1.0
 */
public class Test3 {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + stones[i - 1];
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 只有一块石头，分数为0
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if ((j - i + 1) / 2 == 0) {
                    // 偶数块石头，最后是bob取，所以应该上一次取的分数减去bob这一次的得分
                    int score1 = dp[i + 1][j] - (preSum[j + 1] - preSum[i + 1]); // 取左边的石头
                    int score2 = dp[i][j - 1] - (preSum[j] - preSum[i]); // 取右边的石头
                    dp[i][j] = Math.min(score1, score2);
                } else {
                    // 奇数块石头，最后是alise取，所以应该是alise这一次的得分，减去上一次取石头的最后分数（上一次是bob取）
                    int score1 = (preSum[j + 1] - preSum[i + 1]) - dp[i + 1][j];
                    int score2 = (preSum[j] - preSum[i]) - dp[i][j - 1];
                    dp[i][j] = Math.max(score1, score2);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][n - 1];
    }
}
