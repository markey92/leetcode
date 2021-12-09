package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.zero
 * @ClassName: Leetcode50
 * @Author: markey
 * @Description:
 * @Date: 2021/12/5 16:25
 * @Version: 1.0
 */
public class Leetcode50 {
    public static double myPow(double x, int n) {
        long N = n;
        return n > 0 ? quickMul(x, N) : 1.0/ quickMul(x, -N);
    }

    public static double quickMul(double x, long n) {
        double res = 1.0;
        double x_contribute = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x_contribute;
            }
            x_contribute *= x_contribute;
            n /= 2;
        }
        return res;
    }
}
