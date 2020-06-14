package competition.day20200524;

import java.util.Arrays;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200524
 * @ClassName: Array5419
 * @Author: markey
 * @Description:5419. 两个子序列的最大点积
 * 给你两个数组 nums1 和 nums2 。
 *
 * 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。
 *
 * 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4,5] 的一个子序列而 [1,5,3] 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * 输出：18
 * 解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
 * 它们的点积为 (2*3 + (-2)*(-6)) = 18 。
 * 示例 2：
 *
 * 输入：nums1 = [3,-2], nums2 = [2,-6,7]
 * 输出：21
 * 解释：从 nums1 中得到子序列 [3] ，从 nums2 中得到子序列 [7] 。
 * 它们的点积为 (3*7) = 21 。
 * 示例 3：
 *
 * 输入：nums1 = [-1,-1], nums2 = [1,1]
 * 输出：-1
 * 解释：从 nums1 中得到子序列 [-1] ，从 nums2 中得到子序列 [1] 。
 * 它们的点积为 -1 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 100
 *
 *
 * 点积：
 *
 * 定义 a = [a1, a2,…, an] 和 b = [b1, b2,…, bn] 的点积为：
 *
 * \mathbf{a}\cdot \mathbf{b} = \sum_{i=1}^n a_ib_i = a_1b_1 + a_2b_2 + \cdots + a_nb_n
 *
 * 这里的 Σ 指示总和符号。
 * @Date: 2020/5/24 10:58
 * @Version: 1.0
 */
public class Dp5419 {
    public static void main(String[] args) {
        int[] nums1 = new int[] {-3,-8,3,-10,1,3,9};
        int[] nums2 =  new int[] {9,2,3,7,-9,1,-8,5,-1,-1};
        System.out.println(maxDotProduct(nums1, nums2));
    }
    public static int maxDotProduct(int[] nums1, int[] nums2) {
        // 记录dp[i][j]表示已nums1的前i位和nums2的前j位的最大点积
        // 则dp[i][j] = dp[i-1][j-1] + nums1[i] * nums2[j] || 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        // 初始化动态规划表
        int dp[][] = new int[length1][length2];
        dp[0][0] = nums1[0] * nums2[0];
        int max = dp[0][0];
        for (int i = 1; i < length1; i++) {
            dp[i][0] = Math.max(dp[i-1][0], nums1[i] * nums2[0]);
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 1; i < length2; i++) {
            dp[0][i] = Math.max(dp[0][i-1], nums1[0] * nums2[i]);
            max = Math.max(max, dp[0][i]);
        }
        // 遍历所有场景
        for (int i = 1; i < length1; i++) {
            for (int j = 1; j < length2; j++) {
                /**
                 * 则dp[i][j] 最大点积有三种情况
                 * 1、如果算上nums1[i] * nums2[j]，则有
                 *      a、nums1[i] * nums2[j] > 0 dp[i-1][j-1] < 0, 最大点积是nums1[i] * nums2[j]
                 *      b、nums1[i] * nums2[j] < 0 dp[i-1][j-1] > 0, 最大点积是dp[i-1][j-1]
                 *      c、nums1[i] * nums2[j] > 0 dp[i-1][j-1] > 0, 最大点积是dp[i-1][j-1] + nums1[i] * nums2[j]
                 *      d、nums1[i] * nums2[j] < 0 dp[i-1][j-1] < 0, 最大点积是dp[i-1][j-1] 和 nums1[i] * nums2[j]比较小的一个
                 * 2、还有可能是dp[i-1][j];
                 * 3、还有可能是dp[i][j-1]
                 * 以上三种情况求最大值
                 */
                // 这段计算可以覆盖第一种情况
                dp[i][j] = dp[i-1][j-1];
                int product = nums1[i] * nums2[j];
                if (product > 0) {
                    dp[i][j] = product + (dp[i-1][j-1] > 0 ? dp[i-1][j-1] : 0);
                } else {
                    // 这种情况其实可以省略，因为下面还会跟dp[i-1][j]、dp[i][j-1]做比较，会包含这种场景
                    dp[i][j] = Math.max(dp[i-1][j-1], product);
                }
                // 剩下两种情况
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                max = Math.max(max, dp[i][j]);
                for (int k = 0; k < length1; k++) {
                    System.out.println(Arrays.toString(dp[k]));
                }
            }
        }
        for (int i = 0; i < length1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return max;
    }
}
