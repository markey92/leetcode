package com.markey.leetcode.three;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode368
 * @Author: markey
 * @Description:
 * @Date: 2021/4/23 22:40
 * @Version: 1.0
 */
public class Leetcode368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer>[] dp = new List[n]; // dp[i]表示可以被从左往右可以被nums[i] 整除的数
        dp[0] = new ArrayList<>();
        dp[0].add(nums[0]);
        List<Integer> max = new ArrayList<>();
        max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j].size() + 1 > dp[i].size()) {
                    // num[j] 可以被num[i] 整除，而且dp[j]中的数都可以被num[j]整除，这些数都能被num[i]整除
                    dp[i] = new ArrayList<>(dp[j]);
                    dp[i].add(nums[i]);
                }
                if (dp[i].size() > max.size()) {
                    max = dp[i];
                }
            }
        }
        return max;
    }
}
