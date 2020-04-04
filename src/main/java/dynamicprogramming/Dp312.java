package dynamicprogramming;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp312
 * @Author: markey
 * @Description:312. 戳气球
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/26 22:33
 * @Version: 1.0
 */
public class Dp312 {
    public static void main(String[] args) {
        maxCoins(new int[] {3, 1,5,8});
    }
    public static int maxCoins(int[] nums) {
        // 动态规划表，dp[i][j] 表示只有nums[i-j]个气球时的最大硬币数量
        // 所以有初始值dp[i][j] == nums[i] (when i==j) 此时只有一个气球，所以最大数也只能是1*num[i]*1
        // 而题目要求的结果显然是有0-n个气球，即dp[0][n]这个位置的数值
        /**
         * 当要求nums[i-j]这些气球的最大硬币数时，
         * 假设最后一个戳破的气球是第k个，则这些气球以k位为中间分成左右两排。
         * 此时左边和右边都戳完了，得到硬币coinsLeft和coinsRight，则总硬币数就是coinsLef+coinsRight+nums[k]
         * 因为以k为最后一个戳破的气球有很多情况，如何找到硬币数最大的情况，因为总硬币数就是coinsLef+coinsRight+nums[k]
         * 所以当coinsLeft和coinsRight均最大时，总硬币数最大
         * 而什么情况下coinsLeft和coinsRight最大，就是求有nums[0,k)这些气球的最大硬币数，和nums(k, n]这些气球的最大硬币数
         * 状态转化方程得出如下：
         * maxCoins[0-j] = Max(maxCoins[0,k) + maxCoins(k,n] + nums[k]);
         */
        

        // 初始化dp
        int n = nums.length;
        /**
         * 如示例的数据，矩阵初始化后应该是这样的
         * 3  0  0  0
         * 0  1  0  0
         * 0  0 05  0 <- 从这个位置开始填充
         * 0  0  0 08
         */
        // 根据状态转化方程来填充dp
        if (nums.length == 3) {
//            return getMax(nums[0], nums);
        }
        return 0;
        
    }

    private static int getMax(int[] nums , int i, int j, int a, int b, int c) {
        if (j - i == 0) {
            return nums[j];
        }
        int res = a * b + b * c + Math.max(b, c);
        res = Math.max(res, a * b * c + a * c + Math.max(a, c));
        res = Math.max(res, b * c + a * b + Math.max(a, b));
        return res;

    }
}
