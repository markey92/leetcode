package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF16
 * @Author: markey
 * @Description:面试题16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *  
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/5 23:42
 * @Version: 1.0
 */
public class LCOF16 {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (n == 0) {
            return x == 0 ? 0 : 1;
        } else if (n > 0) {
            return pow(x, n);
        } else {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (pow(x, -1 - n) * x);
            }
            return 1.0 / pow(x, 0 - n);
        }
    }

    public double pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        System.out.println(n);
        double y = pow(x, n/2);
        return y * y * (n % 2 == 1 ? x : 1);
    }
}
