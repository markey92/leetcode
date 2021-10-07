package competition.year2021.day20210411;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210411
 * @ClassName: Leetcode5728
 * @Author: markey
 * @Description:
 * @Date: 2021/4/11 10:37
 * @Version: 1.0
 */
public class Leetcode5728 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n][3];
        for (int i = n - 2; i >= 0; i--) {
            if (obstacles[i] != 0) {
                dp[i][obstacles[i] - 1] = Integer.MAX_VALUE;
            }
            Integer min = Integer.MAX_VALUE;
            if (obstacles[i] != 1) {
                min = Math.min(dp[i + 1][0], min);
            }
            if (obstacles[i] != 2) {
                min = Math.min(dp[i + 1][1], min);
            }
            if (obstacles[i] != 3) {
                min = Math.min(dp[i + 1][2], min);
            }
            if (obstacles[i] != 1) {
                dp[i][0] = Math.min(dp[i + 1][0], min + 1);
            }
            if (obstacles[i] != 2) {
                dp[i][1] = Math.min(dp[i + 1][1], min + 1);
            }
            if (obstacles[i] != 3) {
                dp[i][2] = Math.min(dp[i + 1][2], min + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[0][1];
    }
}
