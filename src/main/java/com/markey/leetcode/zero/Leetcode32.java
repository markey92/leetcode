package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode32
 * @Author: markey
 * @Description:
 * @Date: 2020/7/4 10:40
 * @Version: 1.0
 */
public class Leetcode32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
    /**
     * 动态规划做法
     */
    public static int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            // 左括号的情况肯定构不成有效括号，忽略
            if (s.charAt(i) == ')') {
                // 下面都是s.charAt(i) == ')'的情况
                if (s.charAt(i - 1) == '(') {
                    // 当前是右括号，且前一个是左括号，则刚好可以构成有效括号的后缀
                    if (i > 1) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                    max = Math.max(max, dp[i]);
                } else {
                    // 当前是右括号，且前一个也是右括号
                    int preIndex = (i - 1) - dp[i - 1] + 1; // 前面已知有效字符串的起始下标
                    if (preIndex > 0 && s.charAt(preIndex - 1) == '(') {
                        dp[i] += dp[i - 1] + 2;
                        if (preIndex - 2 > 0) {
                            // s[x,i]是有效字符串，但是最长还要加上再往前的可能字符串
                            dp[i] += dp[preIndex - 2];
                        }
                        max = Math.max(max, dp[i]);
                    }
                }
                // 这时候是否有人要问，那当前是右括号，前一位也是右括号，再前一位也是右括号的情景呢，你怎么不考虑了
                // 实际上是确实有这种情况，但是，在处理前一个字符的时候已经处理了（前一个字符也会连续两个字符是右括号的情况），
                // 所以此次不用再处理了。
            }
        }
//        System.out.println(Arrays.toString(dp));
        return max;
    }
}
