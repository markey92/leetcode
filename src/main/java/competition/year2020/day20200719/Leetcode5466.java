package competition.year2020.day20200719;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200719
 * @ClassName: Leetcode5466
 * @Author: markey
 * @Description:
 * @Date: 2020/7/19 11:24
 * @Version: 1.0
 */
public class Leetcode5466 {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        List<String> [] dp = new List[n]; //
        List<String> first = new ArrayList<>();
        if (!hasChar(String.valueOf(s.charAt(0)), s.substring(1))) {
            first.add(String.valueOf(s.charAt(0)));
        }
        dp[0] = first;
        for (int i = 1; i < n; i++) {
            int start = s.indexOf(s.charAt(i));
            dp[i] = new ArrayList<>();
            for (int j = 0; j < start; j++) {
                List<String> temp = new ArrayList<>();
                temp.add(s.substring(start, i + 1));
                String after = s.substring(j + 1);
                dp[j].stream().filter(y -> !hasChar(y, after)).forEach(y -> temp.add(y));
                if (temp.size() > dp[i].size()) {
                    dp[i] = temp;
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    private boolean hasChar(String source, String target) {
//        System.out.println(source + " " + target);
        for (int i = 0; i < target.length(); i++) {
//            System.out.println(target.charAt(i));
            if (source.indexOf(target.charAt(i)) >= 0) {
                return true;
            }
        }
//        System.out.println(false);
        return false;
    }
}
