package competition.year2021.day20210405;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210405
 * @ClassName: Test1
 * @Author: markey
 * @Description:
 * @Date: 2021/4/5 15:00
 * @Version: 1.0
 */
public class Test1 {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        long res = 0;
        while (start < nums.length && end > start) {
            while (end > start && nums[start] + nums[end] > target) {
                end--;
            }
            res += end - start;
            res %= 1000000007;
            start++;
        }
        return (int) res % 1000000007;
    }
}
