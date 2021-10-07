package competition.year2021.day20210328;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210328
 * @ClassName: Leetcode5713
 * @Author: markey
 * @Description:
 * @Date: 2021/3/28 10:30
 * @Version: 1.0
 */
public class Leetcode5713 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c < '0' || c > '9') {
                while (sb.length() > 1 && sb.charAt(0) == '0') {
                    sb.delete(0, 1);
                }
                if (sb.length() > 0) {
                    set.add(sb.toString());
                }
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        if (sb.length() > 0) {
            set.add(sb.toString());
        }
        return set.size();
    }
}
