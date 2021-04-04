package competition.day20210328;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210328
 * @ClassName: Leetcode5716
 * @Author: markey
 * @Description:
 * @Date: 2021/3/28 11:04
 * @Version: 1.0
 */
public class Leetcode5716 {
    public int maxNiceDivisors(int primeFactors) {
        int[] dp = new int[primeFactors + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i <= primeFactors; i++) {
            long max = i - 1;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
            dp[i] = (int) (max  % 1000_000_007);
        }
        System.out.println(Arrays.toString(dp));
        return (int) (dp[primeFactors] % 1000_000_007);
    }
}
