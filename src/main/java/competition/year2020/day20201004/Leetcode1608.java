package competition.year2020.day20201004;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201004
 * @ClassName: Leetcode1608
 * @Author: markey
 * @Description:
 * @Date: 2020/10/7 16:35
 * @Version: 1.0
 */
public class Leetcode1608 {
    public int specialArray(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] > n) {
            // 全部大于n
            return n;
        }

        for (int i = 1; i < n; i++) {
            int res = n - i;
            if (nums[i] >= res && nums[i - 1] < res) {
                // 前一个条件保证至少有n - i个数大于 n - i；后一个条件保证，只有 n - i个数大于n - i
                return res;
            }
        }
        return -1;
    }
}
