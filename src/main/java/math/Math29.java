package math;

/**
 * @ProjectName: leetcode
 * @Package: math
 * @ClassName: Math29
 * @Author: markey
 * @Description:29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/2 16:43
 * @Version: 1.0
 */
public class Math29 {
    //
    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        // 处理正负，同时转化位long，防止越界
        boolean positive = true;
        long x = dividend, y = divisor;
        if (x < 0) {
            positive = !positive;
            x = 0 - x;
        }
        if (y < 0) {
            positive = !positive;
            y = 0 - y;
        }
        // 特殊情况
        if (x < y) {
            return 0;
        }
        long times = 1;
        // 递归
        while (y * times * 2 < x) {
            times *= 2;
        }
        times += divide((int)(x - y * times), (int)y);

        // 返回临界值处理
        if (times == 2147483648l) {
            return positive ? 2147483647 : -2147483648;
        }
        return (int) (positive ? times : 0 - times);
    }
    // 暴力减法，超时
    public int divide1(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        boolean positive = true;
        long x = dividend, y = divisor;
        if (x < 0) {
            positive = !positive;
            x = 0 - x;
        }
        if (y < 0) {
            positive = !positive;
            y = 0 - y;
        }
        System.out.println(x);
        System.out.println(y);
        long times = 0;
        while (x >= y) {
            times++;
            x -= y;
        }
        if (times == 2147483648l) {
            return positive ? 2147483647 : -2147483648;
        }
        return (int) (positive ? times : 0 - times);
    }
}
