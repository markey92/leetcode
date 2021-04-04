package competition.year2020.day20201108;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201108
 * @ClassName: Leetcode5562
 * @Author: markey
 * @Description:
 * @Date: 2020/11/8 10:36
 * @Version: 1.0
 */
public class Leetcode5562 {
    public int minDeletions(String s) {
        Map<Character, Integer> nums = new HashMap<>();
        for (char c : s.toCharArray()) {
            nums.put(c, nums.getOrDefault(c, 0) + 1);
        }
        int[] hash = new int[100001];
        int res = 0;
        for (int value : nums.values()) {
            while (value > 0 && hash[value] != 0) {
                res++;
                value--;
            }
            hash[value]++;
        }
        return res;
    }
}
