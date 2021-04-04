package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode44
 * @Author: markey
 * @Description:
 * @Date: 2020/7/5 18:34
 * @Version: 1.0
 */
public class Leetcode44 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        // 初始化动态规划矩阵
        dp[0][0] = true; // s和p都是空字符，可以匹配
        for (int i = 1; i <= m; i++) {
            // p为空字符串时，无法匹配字符串，除非s也是空字符串
            dp[i][0] = false;
        }
        for (int i = 1; i <= n; i++) {
            // 当s为空字符串时，除非p都是*，否则无法匹配
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // p的字符有三个情况 ？ * 和a-z
                if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // * 可以匹配空格，所以有是否匹配空格的选择
                    // 如果只匹配空格，则
                    boolean res1 = dp[i][j - 1];
                    // 如果匹配一个字符，则
                    boolean res2 = dp[i - 1][j - 1];
                    // 如果匹配多个字符，则
                    boolean res3 = dp[i - 1][j];
                    dp[i][j] = res1 || res2 || res3;
                } else {
                    dp[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
