package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode10
 * @Author: markey
 * @Description:
 * @Date: 2020/7/10 21:44
 * @Version: 1.0
 */
public class Leetcode10 {
    /**
     * 解答错误
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1]; // dp[i][j]表示s的前i个字符和p的前j个字符能否匹配
        // 初始化
        dp[0][0] = true;
        // 动态规划状态转移
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j - 1) == '*') {
                    // * 匹配上一个字符出现0次、1次、两次
                    dp[i][j] = j > 1 && dp[i][j - 2]
                            || i > 1 && s.charAt(i - 1) == p.charAt(i - 2) && dp[i - 1][j];
                } else {
                    dp[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && dp[i-1][j-1];
                }
            }
        }
        return dp[s.length() - 1][p.length() - 1];
    }
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
