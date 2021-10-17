package competition.day20210829;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210829
 * @ClassName: Leetcode5854
 * @Author: markey
 * @Description:
 * @Date: 2021/8/29 10:31
 * @Version: 1.0
 */
public class Leetcode5854 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            min = Math.min(nums[i + k - 1] - nums[i], min);
        }
        return min;
    }
}
