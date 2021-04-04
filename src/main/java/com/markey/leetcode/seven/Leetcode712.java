package com.markey.leetcode.seven;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.seven
 * @ClassName: Leetcode712
 * @Author: markey
 * @Description:
 * @Date: 2021/3/12 20:38
 * @Version: 1.0
 */
public class Leetcode712 {
    public int minimumDeleteSum(String s1, String s2) {
        /**
         * dp[i][j] 表示s1[0,i]和s2[0,j]符合题目要求的结果
         * 状态转移逻辑：
         * dp[i][j] = if s1[i] == s2[j] -> dp[i - 1][j - 1] // 贪心思想，如果只能有一个字符相等，则让其是靠后的那个
         *            else Math.min(dp[i - 1][j] + s1[i], dp[i][j - 1] + s2[j])
         *
         */
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 0 : s1.charAt(0) + s2.charAt(0);
        // 初始化,
        int sum = s1.charAt(0);
        for (int i = 1; i < n1; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                dp[i][0] = sum;
            } else {
                dp[i][0] = dp[i - 1][0] + s1.charAt(i);
            }
            sum += s1.charAt(i);
        }

        // 初始化
        sum = s2.charAt(0);
        for (int i = 1; i < n2; i++) {
            if (s2.charAt(i) == s1.charAt(0)) {
                dp[0][i] = sum;
            } else {
                dp[0][i] = dp[0][i - 1] + s2.charAt(i);
            }
            sum += s2.charAt(i);
        }


        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i), dp[i][j - 1] + s2.charAt(j));
                }
            }
        }

        return dp[n1 - 1][n2 -1];
    }
}
