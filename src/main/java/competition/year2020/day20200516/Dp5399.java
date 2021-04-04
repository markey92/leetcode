package competition.year2020.day20200516;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200516
 * @ClassName: Dp5399
 * @Author: markey
 * @Description:
 * @Date: 2020/5/16 23:06
 * @Version: 1.0
 */
public class Dp5399 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[] {7,6,5,5,5,6,8,7,8}, 12));
    }
    private static Map<Integer, String> cache = new HashMap<>();
    public static String largestNumber(int[] cost, int target) {
        TreeMap<Integer, Integer> costMap = new TreeMap<>((x, y) -> y -x);
        for (int i = 0; i < cost.length; i++) {
            costMap.put(cost[i], i+1);
        }
        System.out.println(costMap);
        String res = helper(costMap, target);
        System.out.println(cache);
        if (res.equals("a")) {
            return "0";
        }
        return res;
    }
    public static String helper(TreeMap<Integer, Integer> costMap, int target) {
        if (target == 0) {
            return "";
        }
        if (target < 0) {
            return "a";
        }
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        String max = "a";
        for (int cost : costMap.keySet()) {
            if (cost == target) {
                max = maxString(max, String.valueOf(costMap.get(cost)));
            } else if (cost < target) {
                String tail = helper(costMap, target - cost);
                if (!tail.contains("a")) {
                    max = maxString(max, costMap.get(cost) + tail);
                }
            }
        }
        cache.put(target, max);
        return max;
    }

    private static String maxString(String x, String y) {
        if (x.contains("a"))  {
            return y;
        }
        if (y.contains("a")) {
            return x;
        }
        if (x.length() != y.length()) {
            return x.length() > y.length() ? x : y;
        }
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                return x.charAt(i) > y.charAt(i) ? x : y;
            }
        }
        return x;
    }
}
