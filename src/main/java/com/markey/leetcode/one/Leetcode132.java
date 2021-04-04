package com.markey.leetcode.one;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode132
 * @Author: markey
 * @Description:
 * @Date: 2021/3/8 21:53
 * @Version: 1.0
 */
public class Leetcode132 {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
            }
        }

        int[] f =new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                f[i] = 0;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j + 1][i]) {
                    f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }
        System.out.println(Arrays.toString(f));
        return f[n - 1];
    }
}
