package com.markey.leetcode.four;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.four
 * @ClassName: Leetcode492
 * @Author: markey
 * @Description:
 * @Date: 2021/10/23 17:15
 * @Version: 1.0
 */
public class Leetcode492 {
    public int[] constructRectangle(int area) {
        int[] res = new int[] {area, 1};
        int start = area, end = 1;
        while (start >= end) {
            if (start * end > area) {
                start--;
            } else if (start * end < area) {
                end++;
            } else {
                res = new int[] {start, end};
                start--;
                end++;
            }
        }
        return res;
    }
}
