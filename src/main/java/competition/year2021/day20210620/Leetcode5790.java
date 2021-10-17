package competition.year2021.day20210620;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210620
 * @ClassName: Leetcode5790
 * @Author: markey
 * @Description:
 * @Date: 2021/6/20 11:00
 * @Version: 1.0
 */
public class Leetcode5790 {
    Map<int[], Integer> cache = new HashMap<>();
    public int[] minDifference(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = min(nums, queries[i][0], queries[i][1]);
        }
        return res;
    }

    private int min(int[] nums, int start, int end) {
        for (Map.Entry<int[], Integer> entry : cache.entrySet()) {
            if (start == entry.getKey()[0] &&  end == entry.getKey()[1]) {
                return entry.getValue();
            }
            System.out.println(Arrays.toString(entry.getKey()) + ":" + entry.getValue());
        }
        int[] subNums = Arrays.copyOfRange(nums, start, end+1);
        Arrays.sort(subNums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < subNums.length - 1; i++) {
            if (subNums[i + 1] != subNums[i]) {
                min = Math.min(min,  Math.abs(subNums[i] - subNums[i + 1]));
            }
        }
        cache.put(new int[]{start, end}, min == Integer.MAX_VALUE ? - 1 : min);
        return min == Integer.MAX_VALUE ? - 1 : min;
    }
}
