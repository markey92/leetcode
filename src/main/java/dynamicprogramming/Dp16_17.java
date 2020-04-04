package dynamicprogramming;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp16_17
 * @Author: markey
 * @Description:
 * @Date: 2020/3/22 17:31
 * @Version: 1.0
 */
public class Dp16_17 {
    // 使用一维数组表示动态规划表，X[i]表示以第i个元素结尾的最大连续数列总和，
    // 则 X[i]=Math.max(nums[i], nums[i] + X[i-1]);
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 结果
        int max = Integer.MIN_VALUE;

        // 初始化动态规划表
        int[] X = new int[nums.length];
        max = X[0] = nums[0];

        // 填充动态规划表
        for (int i = 1; i < X.length; i++) {
            X[i] = Math.max(nums[i], nums[i] + X[i-1]);
            max = Math.max(max, X[i]); // 不属于填充动态规划表内容，是求题解的
        }
        return max;
    }
}
