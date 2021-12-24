package competition.day20211212;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211212
 * @ClassName: Leetcode5952
 * @Author: markey
 * @Description:
 * @Date: 2021/12/12 10:31
 * @Version: 1.0
 */
public class Leetcode5952 {
    public int countPoints(String rings) {
        Map<Character, Set<Character>> count = new HashMap<>();
        for (int i = 0; i < rings.length(); i = i + 2) {
            char p = rings.charAt(i + 1);
            if (!count.containsKey(p)) {
                count.put(p, new HashSet<>());
            }
            count.get(p).add(rings.charAt(i));
        }
        int res = 0;
        for(char c : count.keySet()) {
            if (count.get(c).size() == 3) {
                res++;
            }
        }
        return res;
    }
}
