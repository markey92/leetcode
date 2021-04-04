package competition.year2020.day20201206;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201206
 * @ClassName: Leetcode5618
 * @Author: markey
 * @Description:
 * @Date: 2020/12/6 10:34
 * @Version: 1.0
 */
public class Leetcode5618 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int res = 0;
        while (start < end) {
            int temp = nums[start] + nums[end];
            if (temp == k) {
                res++;
                start++;
                end--;
            } else if (temp < k) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }
}
