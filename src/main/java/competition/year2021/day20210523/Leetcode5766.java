package competition.year2021.day20210523;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210523
 * @ClassName: Leetcode5766
 * @Author: markey
 * @Description:
 * @Date: 2021/5/23 11:02
 * @Version: 1.0
 */
public class Leetcode5766 {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] presum = new int[n];
        presum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + stones[i];
        }

        int[] max = new int[n];
        max[n - 1] = presum[n - 1]; // alice第一次直接全部拿走
        int res = max[n - 1];
        for (int i = n - 2; i > 0; i--) {
            max[i] = presum[i] - res;
            res = Math.max(res, max[i]);
        }
        System.out.println(Arrays.toString(max));
        return res;
    }
}
