package competition.day20210822;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210822
 * @ClassName: Leetcode5852
 * @Author: markey
 * @Description:
 * @Date: 2021/8/22 10:54
 * @Version: 1.0
 */
public class Leetcode5852 {
    public static void main(String[] args) {
        int[][] temp = new int[][] {{1},{2},{3}};
        System.out.println(minimizeTheDifference(temp, 100));
    }
    public static int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][target + 1]; // dp[x][y]表示，前x行，每一行取一个数后，与 y的相差绝对值最小是多少?
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int j = 0; j < m; j++) {
            for (int k = 1; k <= target; k++) {
                dp[0][k] = Math.min(dp[0][k], Math.abs(k - mat[0][j]));
            }
        }

        for (int i = 1; i < n; i++) {
            // 每一行
            for (int j = 0; j < m; j++) {
                // 每一列
                for (int k = 0; k <= target; k++) {
                    if (k > mat[i][j]) {
                        dp[i][k] = Math.min(dp[i][k], dp[i - 1][Math.abs(k - mat[i][j])]);
                    } else {
                        // 特殊处理目标值比当前行的值小时，因为所有值都是正数，所以此时要选择n-1的与最小值（1）的结果
                        dp[i][k] = Math.min(dp[i][k], Math.abs(mat[i][j] + dp[i - 1][1] - k) + 1);
                    }
                }
            }
        }
        return dp[n - 1][target];
    }
}
