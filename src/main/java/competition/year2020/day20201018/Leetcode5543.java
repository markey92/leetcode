package competition.year2020.day20201018;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201018
 * @ClassName: Leetcode5543
 * @Author: markey
 * @Description:
 * @Date: 2020/10/18 10:30
 * @Version: 1.0
 */
public class Leetcode5543 {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> indexs = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexs.containsKey(c)) {
                max = Math.max(max, i - indexs.get(c)  - 1);
            } else {
                indexs.put(c, i);
            }
        }
        return max;
    }
}
