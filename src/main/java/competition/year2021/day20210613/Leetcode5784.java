package competition.year2021.day20210613;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210613
 * @ClassName: Leetcode5784
 * @Author: markey
 * @Description:
 * @Date: 2021/6/13 10:31
 * @Version: 1.0
 */
public class Leetcode5784 {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        Map<Character, Integer> count = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
        }
        for (char c : count.keySet()) {
            if (count.get(c) % n != 0) {
                return false;
            }
        }
        return true;
    }
}
