package string;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String49
 * @Author: markey
 * @Description:
 * @Date: 2020/5/17 22:56
 * @Version: 1.0
 */
public class String49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            String sortedS = sort(s);
            if (map.containsKey(sortedS)) {
                map.get(sortedS).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedS, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        map.keySet().forEach(key -> res.add(map.get(key)));
        return res;
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}
