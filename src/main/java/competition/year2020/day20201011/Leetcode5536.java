package competition.year2020.day20201011;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201011
 * @ClassName: Leetcode5536
 * @Author: markey
 * @Description:
 * @Date: 2020/10/11 10:34
 * @Version: 1.0
 */
public class Leetcode5536 {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> next = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            int source = roads[i][0];
            int target = roads[i][1];
            if (!next.containsKey(source)) {
                next.put(source, new HashSet<>());
            }
            next.get(source).add(target);

            if (!next.containsKey(target)) {
                next.put(target, new HashSet<>());
            }
            next.get(target).add(source);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int temp = 0;
                if (next.containsKey(i)) {
                    temp += next.get(i).size();
                }
                if (next.containsKey(j)) {
                    temp += next.get(j).size();
                    if (next.get(j).contains(i)) {
                        temp -= 1;
                    }
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
