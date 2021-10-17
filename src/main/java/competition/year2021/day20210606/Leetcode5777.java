package competition.year2021.day20210606;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210606
 * @ClassName: Leetcode5777
 * @Author: markey
 * @Description:
 * @Date: 2021/6/6 10:43
 * @Version: 1.0
 */
public class Leetcode5777 {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int count = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                res += count;
            }
            count++;
        }
        return res;
    }
}
