package competition.year2021.day20210627;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210627
 * @ClassName: Leetcode5797
 * @Author: markey
 * @Description:
 * @Date: 2021/6/27 10:31
 * @Version: 1.0
 */
public class Leetcode5797 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - 1] * nums[n - 2] - nums[0] * nums[1];
    }
}
