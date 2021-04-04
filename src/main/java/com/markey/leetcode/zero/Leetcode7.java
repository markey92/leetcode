package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode7
 * @Author: markey
 * @Description:
 * @Date: 2020/7/10 21:11
 * @Version: 1.0
 */
public class Leetcode7 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res *10 / 10 != res) {
                // 数值溢出
                res = 0;
                break;
            }
            res *= 10;
            res += x %10;
            x /= 10;
        }
        return res;
    }
}
