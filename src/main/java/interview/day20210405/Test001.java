package interview.day20210405;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20210405
 * @ClassName: Test001
 * @Author: markey
 * @Description:
 * @Date: 2021/4/5 11:43
 * @Version: 1.0
 */
public class Test001 {
    // s的长度最大为16，直接暴力遍历所有情况
    public int maxUniqueSplit(String s) {
        int n = s.length();
        List<Set>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new HashSet());

        for (int i = 1; i <= n; i++) {
            List<Set> setList = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                String lastString = s.substring(j, i);
                for (int k = 0; k < dp[j].size(); k++) {
                    if (!dp[j].get(k).contains(lastString)) {
                        Set<String> temp = new HashSet<>(dp[j].get(k));
                        temp.add(lastString);
                        setList.add(temp);
                    }
                }

            }
            dp[i] = setList;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n].stream().mapToInt(Set::size).max().getAsInt();
    }
}
