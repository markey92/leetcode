package lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF10_1
 * @Author: markey
 * @Description:面试题10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *  
 *
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/16 22:36
 * @Version: 1.0
 */
public class LCOF10_1 {
    /**
     * 一维数组的动态规划，比较好理解
     * 注意题干要求取模
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        long first = 0;
        long second = 1;
        for (int i = 1; i < n; i++) {
            long sum = first + second;
            first = second;
            second = (int) (sum % 1000000007);
        }
        return (int) (second % 1000000007);
    }
}
