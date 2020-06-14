package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String389
 * @Author: markey
 * @Description:
 * @Date: 2020/6/4 22:44
 * @Version: 1.0
 */
public class String389 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return c;
            }
        }
        return ' ';
    }
}
