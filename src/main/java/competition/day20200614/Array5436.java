package competition.day20200614;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200614
 * @ClassName: Array5436
 * @Author: markey
 * @Description:
 * @Date: 2020/6/14 10:30
 * @Version: 1.0
 */
public class Array5436 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }
}
