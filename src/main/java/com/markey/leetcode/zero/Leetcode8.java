package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode8
 * @Author: markey
 * @Description:
 * @Date: 2020/7/10 21:24
 * @Version: 1.0
 */
public class Leetcode8 {
    public int myAtoi(String str) {

        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            // 去除空格
            index++;
        }
        // 判断符号
        boolean positive = true;
        if (index < str.length() && str.charAt(index) == '+') {
            positive = true;
            index++;
        } else if (index < str.length() && str.charAt(index) == '-') {
            positive = false;
            index++;
        }


        // 解析数字
        long res = 0;
        for (; index < str.length(); index++) {
            char temp = str.charAt(index);
            if (temp >= '0' && temp <= '9') {
                res = res * 10 + temp - '0';
            } else {
                break;
            }
            if (res > Integer.MAX_VALUE) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int) (positive ? res : 0 - res);
    }
}
