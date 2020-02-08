package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array532
 * @Author: markey
 * @Description:
 * @Date: 2020/2/8 23:06
 * @Version: 1.0
 */
public class Array532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int res = 0;
        for (int key: map.keySet()) {
            if (k == 0) {
                res += map.get(key) / 2;
            } else {
                if (map.containsKey(key + k)) {
                    int min = Math.min(map.get(key), map.get(key + k));
                    res += min;
                    map.put(key, map.get(key) - min);
                }
            }
        }
        return res;
    }
}
