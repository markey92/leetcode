package competition.year2020.day20200725;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200725
 * @ClassName: Leetcode5458
 * @Author: markey
 * @Description:
 * @Date: 2020/7/25 22:55
 * @Version: 1.0
 */
public class Leetcode5458 {
    public int numSplits(String s) {
        Map<Character, Integer> charRight = new HashMap<>();
        for (char c : s.toCharArray()) {
            charRight.put(c, charRight.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> charLeft = new HashMap<>();
        char temp = ' ';
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            charLeft.put(temp, charLeft.getOrDefault(temp, 0) + 1);
            charRight.put(temp, charRight.getOrDefault(temp, 0) - 1);
            if (charRight.get(temp) == 0) {
                charRight.remove(temp);
            }
            if (charLeft.keySet().size() == charRight.keySet().size()) {
                count++;
            };
        }
        return count;
    }
}
