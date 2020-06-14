package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String821
 * @Author: markey
 * @Description:
 * @Date: 2020/5/22 22:53
 * @Version: 1.0
 */
public class String821 {
    public int[] shortestToChar(String S, char C) {
        Set<Integer> location = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                location.add(i);
            }
        }
        int[] res = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            int min = Integer.MAX_VALUE;
            for(int j : location) {
                min = Math.min(min, Math.abs(j - i));
            }
            res[i] = min;
        }
        return res;
    }
}
