package com.markey.leetcode.two;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.two
 * @ClassName: Leetcode214
 * @Author: markey
 * @Description:
 * @Date: 2021/10/8 21:50
 * @Version: 1.0
 */
public class Leetcode214 {
    public static void main(String[] args) {
        Leetcode214 leetcode214 = new Leetcode214();
        leetcode214.shortestPalindrome1("aacecaaa");
    }

    public String shortestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int n = s.length();
        boolean[] dp = new boolean[n]; // dp[i][j]表示s的子字符串s.subString(i, j+1)是否是回文字符串
        Arrays.fill(dp, true);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                dp[j] = (s.charAt(i) == s.charAt(j)) && dp[j - 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        int start = 0;
        for (int i = n - 1; i > 0; i--) {
            if (dp[i]) {
                start = i;
                break;
            }
        }
        return new StringBuilder(s.substring(start + 1)).reverse().append(s).toString();
    }
    // 暴力，超时
    public String shortestPalindrome1(String s) {
        for (int i = s.length(); i > 0; i--) {
            StringBuilder stringBuilder = new StringBuilder(s.subSequence(0, i));
            System.out.println(stringBuilder.toString());
            System.out.println(stringBuilder.reverse());
            if (stringBuilder.toString().equals(stringBuilder.reverse().toString())) {
                return new StringBuilder(s.substring(i)).reverse().append(s).toString();
            }
        }
        return new StringBuilder(s).reverse().toString() + s;
    }
}
