package dynamicprogramming;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp17_16
 * @Author: markey
 * @Description:面试题 17.16. 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/22 17:49
 * @Version: 1.0
 */
public class Dp17_16 {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        /**
         * 使用一维数组记录
         * X[i]表示接受第i次预约时，此前(包括这一次)按摩师的工作时间总数
         * 则有:
         * 按摩师接收此次预约，则他不能接收上一次的预约
         * X[i] = nums[i] + Math.max(X[0]~X[i-2]);
         * 因为X[i-3] > x[i-5], X[i-2] > X[i-4],……
         * 所以X[i] = nums[i] + Math.max(X[i-2],X[i-3]);
         */

        // 初始化动态规划表
        int[] X = new int[nums.length];
        X[0] = nums[0];
        X[1] = nums[1];
        X[2] = X[0] + nums[2];

        int res = Math.max(Math.max(X[0], X[1]), X[2]);
        for (int i = 3; i < X.length; i++) {
            X[i] = Math.max(X[i-2], X[i-3]) + nums[i];
            res = Math.max(res, X[i]);
        }
        return res;
    }
}
