package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String139
 * @Author: markey
 * @Description:
 * @Date: 2020/3/31 22:39
 * @Version: 1.0
 */
public class String139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);  // 用set会快一点
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
    // 超时
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }
        for (int j = 0; j < wordDict.size(); j++) {
            String prefex = wordDict.get(j);
            if (s.length() >= prefex.length() && s.startsWith(prefex)) {
                if (wordBreak1(s.substring(prefex.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
