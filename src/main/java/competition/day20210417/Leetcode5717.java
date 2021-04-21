package competition.day20210417;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210417
 * @ClassName: Leetcode5717
 * @Author: markey
 * @Description:
 * @Date: 2021/4/17 22:32
 * @Version: 1.0
 */
public class Leetcode5717 {
    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}
