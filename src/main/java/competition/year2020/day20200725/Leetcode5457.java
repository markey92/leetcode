package competition.year2020.day20200725;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200725
 * @ClassName: Dp5457
 * @Author: markey
 * @Description:
 * @Date: 2020/7/25 22:40
 * @Version: 1.0
 */
public class Leetcode5457 {
    public int numOfSubarrays(int[] arr) {
        int[][] dp = new int[arr.length + 1][2];
        for (int i = 1; i <= arr.length; i++) {
            if (arr[i - 1] % 2 == 1) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }
        }
        long res = 0;
        for (int i = 0; i < dp.length; i++) {
            res += dp[i][0];
            res %= 10000007;
        }
        return (int) res;
    }
}
