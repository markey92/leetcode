package competition.year2020.day20200711;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200711
 * @ClassName: Dp5447
 * @Author: markey
 * @Description:
 * @Date: 2020/7/11 23:13
 * @Version: 1.0
 */
public class Dp5447 {
    public boolean winnerSquareGame(int n) {
        boolean dp[] = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (dp[i - j * j] == false) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
