package com.markey.leetcode.three;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode377
 * @Author: markey
 * @Description:
 * @Date: 2021/4/24 10:14
 * @Version: 1.0
 */
public class Leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        // dp[i]表示和为i的组合个数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    // 和为i-num[j]的个数，这些组合都可以加上num[j]使得组合和为i
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
