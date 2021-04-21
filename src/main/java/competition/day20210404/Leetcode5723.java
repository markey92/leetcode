package competition.day20210404;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210404
 * @ClassName: Leetcode5723
 * @Author: markey
 * @Description:
 * @Date: 2021/4/4 10:34
 * @Version: 1.0
 */
public class Leetcode5723 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] item : logs) {
            if (!map.containsKey(item[0])) {
                map.put(item[0], new HashSet<>());
            }
            map.get(item[0]).add(item[1]);
        }
        for (int id : map.keySet()) {
            res[map.get(id).size() - 1]++;
        }
        return res;
    }
}
