package competition.year2020.day20200920;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200920
 * @ClassName: Leetcode5520
 * @Author: markey
 * @Description:
 * @Date: 2020/9/20 10:38
 * @Version: 1.0
 */
public class Leetcode5520 {
    public int maxUniqueSplit(String s) {
        int n = s.length();
        if (n == 1) {
            return 1;
        }
        Set<String>[] dp = new Set[n];
        dp[0] = new HashSet<>();
        dp[0].add(s.substring(0, 1));
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int pre = i - 1;
            while (pre >= 0) {
                String newString = s.substring(pre + 1, i + 1);
                if (dp[pre].contains(newString)) {
                    pre--;
                } else {
                    Set<String> newSet = new HashSet<>(dp[pre]);
                    newSet.add(newString);
                    dp[i] = newSet;
                    break;
                }
            }
            if (pre == -1) {
                Set<String> newSet = new HashSet<>();
                newSet.add(s.substring(0, i + 1));
                dp[i] = newSet;
            }
            max = Math.max(max, dp[i].size());
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
