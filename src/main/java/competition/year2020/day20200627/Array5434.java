package competition.year2020.day20200627;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200627
 * @ClassName: Array5434
 * @Author: markey
 * @Description:
 * @Date: 2020/6/27 22:38
 * @Version: 1.0
 */
public class Array5434 {
    public int longestSubarray(int[] nums) {
        // 左边前缀和
        int[] leftSumOf0 = new int[nums.length];
        int count = 0;
        for (int i = 0; i < leftSumOf0.length; i++) {
            leftSumOf0[i] = count;
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
        }

        // 右边前缀和
        int[] rightSumOf0 = new int[nums.length];
        count = 0;
        for (int i = leftSumOf0.length - 1; i >= 0; i--) {
            rightSumOf0[i] = count;
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(leftSumOf0[i] + rightSumOf0[i], res);
        }
        return res;
    }
}
