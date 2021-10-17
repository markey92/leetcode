package com.markey.leetcode.five;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.five
 * @ClassName: Leetcode567
 * @Author: markey
 * @Description:
 * @Date: 2021/8/2 20:35
 * @Version: 1.0
 */
public class Leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] target = new int[26];
        for (char c : s1.toCharArray()) {
            target[c - 'a']++;
        }
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(target, count)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i - s1.length()) - 'a']--;
            count[s2.charAt(i) - 'a']++;
            if (Arrays.equals(target, count)) {
                return true;
            }
        }
        return false;
    }
}
