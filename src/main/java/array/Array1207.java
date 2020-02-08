package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array1207
 * @Author: markey
 * @Description:
 * @Date: 2020/2/5 22:22
 * @Version: 1.0
 */
public class Array1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> countSet = new HashSet<>();
        for (Integer key: count.keySet()) {
            countSet.add(count.get(key));
        }
        return countSet.size() == count.size();
    }
}
