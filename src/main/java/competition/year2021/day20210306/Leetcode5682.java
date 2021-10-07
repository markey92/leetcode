package competition.year2021.day20210306;

import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210306
 * @ClassName: Leetcode5682
 * @Author: markey
 * @Description:
 * @Date: 2021/3/7 11:55
 * @Version: 1.0
 */
public class Leetcode5682 {
    public int beautySum(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] count = new int[26];
            count[s.charAt(i) - 'a']++;
            count[s.charAt(i + 1) - 'a']++;
            for (int j = i + 2; j < n; j++) {
                count[s.charAt(j) - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (count[i] > 0) {
                        max = Math.max(max, count[i]);
                        min = Math.min(min, count[i]);
                    }
                }
                res += max - min;
            }
            // System.out.println("i:" + i + ":" + count.values());

        }
        return res;
    }

    public int get(List<Integer> counts) {
        int max = counts.get(0);
        int min = counts.get(0);
        for (int i = 0; i < counts.size(); i++) {
            max = Math.max(max, counts.get(i));
            min = Math.min(min, counts.get(i));
        }
        return max - min;
    }
}
