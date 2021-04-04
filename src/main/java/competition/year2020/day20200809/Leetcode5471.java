package competition.year2020.day20200809;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200809
 * @ClassName: Leetcode5471
 * @Author: markey
 * @Description:
 * @Date: 2020/8/9 11:21
 * @Version: 1.0
 */
public class Leetcode5471 {
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        int start = -1;
        int end = 1;
        int res = 0;
        int count = 0;
        Map<Integer, Integer> lastIndex = new HashMap<>();
        lastIndex.put(0, -1);
        while (end < n) {
            count += nums[end];
            if (lastIndex.containsKey(count - target) && lastIndex.get(count - target) >= start) {
                System.out.println(lastIndex.get(count - target) + " " + end);
                res++;
                start = end;
            }
            lastIndex.put(count, end);
            end++;
            System.out.println(lastIndex);
        }
        return res;
    }
}
