package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String5333
 * @Author: markey
 * @Description:
 * @Date: 2020/2/9 10:48
 * @Version: 1.0
 */
public class String5333 {
    public int minSteps(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();
        int res = 0;
        for (char c: s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }
        for (char c: t.toCharArray()) {
            if (mapS.getOrDefault(c, 0) > 0) {
                mapS.put(c, mapS.get(c) - 1);
            } else {
                res++;
            }
        }
        return res;
    }
}
