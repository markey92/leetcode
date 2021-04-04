package competition.year2020.day20200919;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200919
 * @ClassName: Leetcode5504
 * @Author: markey
 * @Description:
 * @Date: 2020/9/19 23:03
 * @Version: 1.0
 */
public class Leetcode5504 {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int[] remind = new int[n];
        remind[0] = nums[0] % p;
        for (int i = 1; i < n; i++) {
            remind[i] = (remind[i - 1] + nums[i]) % p;
        }
        System.out.println(Arrays.toString(remind));
        int target = remind[n - 1];
        if (target == 0) {
            return 0;
        }
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int now = remind[i];
            if (now == 0) {
                res = Math.min(res, n - i);
            }
            if (target - now != now && lastIndex.containsKey(target - now)) {
                res = Math.min(res, i - lastIndex.get(target - now));
            }
            if (lastIndex.containsKey(target)) {
                res = Math.min(res, i - lastIndex.get(target));
            }
            lastIndex.put(now, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
