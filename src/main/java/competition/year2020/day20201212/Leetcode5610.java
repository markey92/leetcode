package competition.year2020.day20201212;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201212
 * @ClassName: Leetcode5610
 * @Author: markey
 * @Description:
 * @Date: 2020/12/12 22:32
 * @Version: 1.0
 */
public class Leetcode5610 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        int[] lastSum = new int[n];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + preSum[i - 1];
            lastSum[n - 1 - i] = lastSum[n - i] + nums[n - i];
        }
        System.out.println(Arrays.toString(preSum));
        System.out.println(Arrays.toString(lastSum));
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = (nums[i] * i - preSum[i]) + (lastSum[i] - nums[i] * (n - 1 - i));
        }
        return res;
    }
}
