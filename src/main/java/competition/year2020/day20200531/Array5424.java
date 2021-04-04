package competition.year2020.day20200531;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200531
 * @ClassName: Array5424
 * @Author: markey
 * @Description:
 * @Date: 2020/5/31 10:35
 * @Version: 1.0
 */
public class Array5424 {
    public int maxProduct(int[] nums) {

        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        max = Math.max(max, (nums[0] - 1) * (nums[1] - 1));
        max = Math.max(max, (nums[nums.length - 1] -1 ) * (nums[nums.length - 2] - 1 ));
        return max;
    }
}
