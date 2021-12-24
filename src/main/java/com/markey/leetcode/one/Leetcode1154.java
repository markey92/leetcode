package com.markey.leetcode.one;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode1154
 * @Author: markey
 * @Description:
 * @Date: 2021/12/21 21:42
 * @Version: 1.0
 */
public class Leetcode1154 {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int[] numOfMonth = new int[] {31, 28, 31, 30, 31, 30,31,31,30,31,30,31};
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            numOfMonth[1]++;
        }
        int res = 0;
        for (int i = 1; i < month; i++) {
            res += numOfMonth[i - 1];
        }
        return res + day;
    }
}
