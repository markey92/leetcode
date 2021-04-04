package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode87
 * @Author: markey
 * @Description:
 * @Date: 2020/7/26 21:02
 * @Version: 1.0
 */
public class Leetcode87 {
    public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
        // 初始化三维dp表
        boolean[][][] dp = new boolean[n][n][n + 1]; // n+1只是为了表示长度好看点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        // 状态转移
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    // 枚举划分位置
                    for (int k = 1; k <= len; k++) {
                        if (dp[i][j][k] && dp[i+k][j+k][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i][j+ len -k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
