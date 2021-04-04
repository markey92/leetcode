package competition.year2020.day20200712;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200712
 * @ClassName: Map5460
 * @Author: markey
 * @Description:
 * @Date: 2020/7/12 10:30
 * @Version: 1.0
 */
public class Map5460 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                res += map.get(num);
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return res;
    }
}
