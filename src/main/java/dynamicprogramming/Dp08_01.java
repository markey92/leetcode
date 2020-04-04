package dynamicprogramming;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: DP08_01
 * @Author: markey
 * @Description:面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/22 18:22
 * @Version: 1.0
 */
public class Dp08_01 {
    // 斐波那契数列的变体
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        long[] X = new long[n+1];
        X[0] = 0;
        X[1] = 1;
        X[2] = 2;
        X[3] = 4;
        for (int i = 4; i < n+1; i++) {
            // 第i阶可以是跨1、2、3步上来的
            X[i] = (X[i-3] + X[i-2] + X[i-1]) % 1000000007;
        }
        return (int) X[n];
    }
}
