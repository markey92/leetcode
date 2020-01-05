package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array53
 * @Author: markey
 * @Description:
 * @Date: 2019/10/17 22:16
 * @Version: 1.0
 */
public class Array53 {
    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了99.97%的用户
     * 内存消耗 :41.4 MB, 在所有 java 提交中击败了62.55%的用户
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int currentMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i: nums) {
            currentMax = Math.max(currentMax + i, i);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
