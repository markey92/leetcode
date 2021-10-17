package com.markey.leetcode.six;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.six
 * @ClassName: Leetcode633
 * @Author: markey
 * @Description:
 * @Date: 2021/4/28 20:46
 * @Version: 1.0
 */
public class Leetcode633 {
    public static void main(String[] args) {
        System.gc();
        System.out.println(judgeSquareSum(1000));
    }
    public static boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int res = left * left + right * right;
            if (res > c) {
                right--;
            } else if (res < c) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}
