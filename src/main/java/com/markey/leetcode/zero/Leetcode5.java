package com.markey.leetcode.zero;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode5
 * @Author: markey
 * @Description:
 * 动态规划
 * @Date: 2020/6/26 16:09
 * @Version: 1.0
 */
public class Leetcode5 {
    public String longestPalindrome(String s) {
        /**
         * 动态规划 dp[i][j]表示s.substring(i,j+1)是否是回文字符串，
         * 则dp[i][j] = dp[i+1][j-1] && s.charAt(j) == s.charAt(i)
         * 注意：这里有个异常场景，当j = i+1时，dp[i+1][j-1] = dp[j][i], 上述等式不成立，此时
         */
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化动态规划表
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int j = 0; j < s.length(); j++) {
            dp[j-1][j] = s.charAt(j-1) == s.charAt(j);
            for (int i = j - 2; i >= 0; i--) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        // 找出j-i的最大值，并且dp[i][j] == true
        int max = 1;
        String res = "";
        for (int j = 0; j < s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (dp[i][j] && j + 1 - i > max) {
                    max = j + 1 - i;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
    /**
     * 动态规划 dp[i][j]表示s.substring(j,i+1)是否是回文字符串，
     * 则dp[i][j] = dp[i-1][j+1] && s.charAt(j) == s.charAt(i)
     *
     */
    public String longestPalindrome1(String s) {
        String res = "";
        int[][] dp = new int[s.length()][s.length()]; // 所有可能是字符串集合,1表示回文，0表示不回文
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    res = res.length() < i - j + 1 ? s.substring(j, i + 1) : res; // 取最长回文子串
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j + 1 > i - 1) {
                        // 这种情况其实i和j相邻了，想想i和j相邻，并且他们字符一样，那肯定是长度位2的回文子串
                        dp[i][j] = 1;
                        res = res.length() < i - j + 1 ? s.substring(j, i + 1) : res; // 取最长回文子串
                        continue;
                    }
                    if (dp[i-1][j+1] == 1) {
                        dp[i][j] = 1;
                        res = res.length() < i - j + 1 ? s.substring(j, i + 1) : res; // 取最长回文子串
                        continue;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return res;
    }
}
