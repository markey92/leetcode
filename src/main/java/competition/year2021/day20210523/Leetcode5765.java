package competition.year2021.day20210523;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210523
 * @ClassName: Leetcode5765
 * @Author: markey
 * @Description:
 * @Date: 2021/5/23 10:56
 * @Version: 1.0
 */
public class Leetcode5765 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (dp[i] == false) {
                continue;
            }
            for (int j = i + minJump; j <= i + maxJump && j < n && dp[j] == false; j++) {
                dp[j] = s.charAt(j) == '0';
            }
        }
        return dp[n - 1];
    }
}
