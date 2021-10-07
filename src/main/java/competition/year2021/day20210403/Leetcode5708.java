package competition.year2021.day20210403;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210403
 * @ClassName: Leetcode5708
 * @Author: markey
 * @Description:
 * @Date: 2021/4/3 22:57
 * @Version: 1.0
 */
public class Leetcode5708 {
    public int countNicePairs(int[] nums) {
        Map<Integer, Long> count =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - reverse(nums[i]);
            count.put(diff, count.getOrDefault(diff, 0l) + 1);
        }
        long res = 0;
        for (long value: count.values()) {
            res += ((value * (value - 1)) / 2) % 1_000_000_007;
        }
        return (int) (res % 1_000_000_007);
    }

    public int reverse(int x) {
        int y = 0;
        while (x > 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}
