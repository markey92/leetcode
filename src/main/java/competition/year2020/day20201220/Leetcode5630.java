package competition.year2020.day20201220;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201220
 * @ClassName: Leetcode5630
 * @Author: markey
 * @Description:
 * @Date: 2020/12/20 10:50
 * @Version: 1.0
 */
public class Leetcode5630 {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> res = new HashSet<>();
        int sum = 0;
        int max = 0;
        int start = 0, end = 0;
        while (end < nums.length) {
            int i = nums[end];
            while (res.contains(i)) {
                res.remove(nums[start]);
                sum -= nums[start];
                start++;
            }
            res.add(i);
            sum += i;
            max = Math.max(max, sum);
            end++;
        }
        return max;
    }
}
