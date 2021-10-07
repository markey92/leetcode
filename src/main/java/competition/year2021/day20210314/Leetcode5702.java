package competition.year2021.day20210314;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210314
 * @ClassName: Leetcode5702
 * @Author: markey
 * @Description:
 * @Date: 2021/3/14 10:46
 * @Version: 1.0
 */
public class Leetcode5702 {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] edge : edges) {
            count.put(edge[0], count.getOrDefault(edge[0], 0) + 1);
            count.put(edge[1], count.getOrDefault(edge[1], 0) + 1);
        }
        for (int key: count.keySet()) {
            if (count.get(key) == count.size() - 1) {
                return key;
            }
        }
        return -1;
    }
}
