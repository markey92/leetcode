package map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: map
 * @ClassName: Map884
 * @Author: markey
 * @Description:
 * @Date: 2020/6/3 22:23
 * @Version: 1.0
 */
public class Map884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        Map<String, Integer> mapA = new HashMap<>();
        for(String s: a) {
            mapA.put(s, mapA.getOrDefault(s, 0) + 1);
        }
        String[] b = B.split(" ");
        Map<String, Integer> mapB = new HashMap<>();
        for(String s: b) {
            mapB.put(s, mapB.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (String key : mapA.keySet()) {
            if (mapA.get(key) == 1 && !mapB.containsKey(key)) {
                list.add(key);
            }
        }
        for (String key : mapB.keySet()) {
            if (mapB.get(key) == 1 && !mapA.containsKey(key)) {
                list.add(key);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
