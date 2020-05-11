package math;

/**
 * @ProjectName: leetcode
 * @Package: math
 * @ClassName: Math326
 * @Author: markey
 * @Description:
 * @Date: 2020/5/11 22:21
 * @Version: 1.0
 */
public class Math326 {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        return isPower(n, 3);
    }

    public boolean isPower(int n, int power) {
        if (n == 1) {
            return true;
        }
        if (n % power != 0) {
            return false;
        }
        return isPower(n / power, power);
    }
}
