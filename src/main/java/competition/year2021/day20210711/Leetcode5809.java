package competition.year2021.day20210711;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210711
 * @ClassName: Leetcode5809
 * @Author: markey
 * @Description:
 * @Date: 2021/7/11 10:32
 * @Version: 1.0
 */
public class Leetcode5809 {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] count = new int[n][26];
        count[0][s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                count[i][j] = count[i - 1][j];
                if (s.charAt(i) - 'a' == j) {
                    count[i][j]++;
                }

            }
        }
        Set<String> res = new HashSet<>();
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 26; j++) {
                if (count[i - 1][j] > 0 && count[n - 1][j] - count[i][j] > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((char) ('a' + j));
                    sb.append(s.charAt(i));
                    sb.append((char) ('a' + j));
                    res.add(sb.toString());
                }
            }
        }
        System.out.println(res);
        return res.size();
    }
}
