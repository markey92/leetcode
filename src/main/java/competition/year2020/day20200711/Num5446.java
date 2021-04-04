package competition.year2020.day20200711;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200711
 * @ClassName: Num5446
 * @Author: markey
 * @Description:
 * @Date: 2020/7/11 22:50
 * @Version: 1.0
 */
public class Num5446 {
    public int minDifference(int[] nums) {
        if (nums.length <= 3) {
            return 0;
        }
        Arrays.sort(nums);
        int min = 0;
        int max = nums.length - 1;
        return minDifference(nums, min, max, 3);
    }

    public int minDifference(int[] nums, int min, int max, int n) {
        if (n == 0) {
            return nums[max] - nums[min];
        }
        return Math.min(minDifference(nums, min+1, max, n - 1), minDifference(nums, min, max - 1, n - 1));
//        if (nums[min + 1] - nums[min] > nums[max] - nums[max - 1]) {
//            return minDifference(nums, min+1, max, n - 1);
//        } else if (nums[min + 1] - nums[min] < nums[max] - nums[max - 1]) {
//            return minDifference(nums, min, max - 1, n - 1);
//        } else {
//            return Math.min(minDifference(nums, min+1, max, n - 1), minDifference(nums, min, max - 1, n - 1));
//        }
    }
}
