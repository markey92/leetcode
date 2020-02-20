package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF10_2
 * @Author: markey
 * @Description:面试题10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 * 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/18 23:12
 * @Version: 1.0
 */
public class LCOF10_2 {
    // 原理上是斐波那契数列
    // 青蛙跳到当前台阶只有两种可能，一种是从上一台阶跳一阶上来；一种是从上两台阶跳两阶上来
    // F(n) = F(n-1) + F(n-2)
    // 用动态规划优化下
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int first = 1, now = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (first + now) % 1000000007;
            first = now;
            now = temp;
        }
        return now;
    }
}
