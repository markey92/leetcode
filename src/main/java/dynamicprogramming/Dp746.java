package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Dp746 {
    /**
     * Runtime: 6 ms, faster than 5.02% of Java online submissions for Min Cost Climbing Stairs.
     * Memory Usage: 37.3 MB, less than 94.64% of Java online submissions for Min Cost Climbing Stairs.
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(help(cost, cost.length - 1), help(cost, cost.length - 2));
    }

    public int help(int[] cost, int i) {
        if (i < 0) {
            return 0;
        }
        if (!map.containsKey(i)) {
            map.put(i, Math.min(help(cost, i - 2) + cost[i], help(cost, i - 1) + cost[i]));
        }
        return map.get(i);
    }

    /**
     * Runtime: 1 ms, faster than 99.91% of Java online submissions for Min Cost Climbing Stairs.
     * Memory Usage: 39.5 MB, less than 41.07% of Java online submissions for Min Cost Climbing Stairs.
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs2(int[] cost) {
        int[] res = new int[cost.length];
        for (int i = 0; i < res.length; i++) {
            if (i < 2) {
                res[i] = cost[i];
            } else {
                res[i] = Math.min(res[i-1] + cost[i], res[i-2] + cost[i]);
            }
        }
        return Math.min(res[cost.length-1], res[cost.length-2]);
    }
}
