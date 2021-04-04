package CrackingTheCodingInterview;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode08_11
 * @Author: markey
 * @Description:
 * @Date: 2020/9/27 23:33
 * @Version: 1.0
 */
public class Leetcode08_11 {
    public int waysToChange(int n) {
        int[] coins = new int[] {1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1;

        Arrays.stream(coins).forEach(coin -> {
            for (int i = 0; i <= n; i++) {
                dp[i] += ((i-coin) >= 0 ? dp[i-coin] : 0) % 1000000007;
            }
        });
        return dp[n] % 1000000007;
    }
}
