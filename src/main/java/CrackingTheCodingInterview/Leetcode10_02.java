package CrackingTheCodingInterview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode10_02
 * @Author: markey
 * @Description:
 * @Date: 2020/10/2 10:27
 * @Version: 1.0
 */
public class Leetcode10_02 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            String temp = resort(s);
            if (map.containsKey(temp)) {
                map.get(temp).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(temp, list);
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

    private String resort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }
}
