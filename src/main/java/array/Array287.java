package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array287
 * @Author: markey
 * @Description:
 * @Date: 2020/5/26 21:40
 * @Version: 1.0
 */
public class Array287 {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }
}
