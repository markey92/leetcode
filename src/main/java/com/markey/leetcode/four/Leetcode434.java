package com.markey.leetcode.four;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.four
 * @ClassName: Leetcode
 * @Author: markey
 * @Description:
 * @Date: 2021/10/7 19:21
 * @Version: 1.0
 */
public class Leetcode434 {
    public int countSegments(String s) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (stringBuilder.length() > 0) {
                    count++;
                    stringBuilder.delete(0, stringBuilder.length());
                }
            } else {
                stringBuilder.append(c);
            }
        }
        if (stringBuilder.length() > 0) {
            count++;
        }
        return count;
    }
}
