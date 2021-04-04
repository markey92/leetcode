package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode6
 * @Author: markey
 * @Description:
 * @Date: 2020/7/10 20:56
 * @Version: 1.0
 */
public class Leetcode6 {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() == 0) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        boolean direction = false;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sbs[index] == null) {
                sbs[index] = new StringBuilder();
            }
            sbs[index].append(s.charAt(i));
            // 转向
            if (index == numRows - 1 || index == 0) {
                direction = !direction;
            }
            System.out.println(index);
            index += direction ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sbs.length; i++) {
            if (sbs[i] != null) {
                res.append(sbs[i]);
            }
        }
        return res.toString();
    }
}
