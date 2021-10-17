package interview.day20210424;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20210424
 * @ClassName: Test3
 * @Author: markey
 * @Description:
 * @Date: 2021/4/24 10:30
 * @Version: 1.0
 */
public class Test2 {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[n - 1] - nums[3];
        res = Math.min(res, nums[n - 2] - nums[2]);
        res = Math.min(res, nums[n - 3] - nums[1]);
        res = Math.min(res, nums[n - 4] - nums[0]);
        return res;
    }
}
