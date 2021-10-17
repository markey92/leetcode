package competition.year2021.day20210626;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210626
 * @ClassName: Leetcode5782
 * @Author: markey
 * @Description:
 * @Date: 2021/6/26 22:41
 * @Version: 1.0
 */
public class Leetcode5782 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        long max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i - 1]);
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
//        for (int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return max;
    }
}
