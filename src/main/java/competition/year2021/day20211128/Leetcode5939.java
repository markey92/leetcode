package competition.year2021.day20211128;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.year2021.day20211128
 * @ClassName: Leetcode5939
 * @Author: markey
 * @Description:
 * @Date: 2021/11/28 10:33
 * @Version: 1.0
 */
public class Leetcode5939 {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = k; i < n - k; i++) {
            res[i] = (int) ((preSum[i + 1 + k] - preSum[i - k]) / (2 * k + 1));
        }
        return res;
    }
}
