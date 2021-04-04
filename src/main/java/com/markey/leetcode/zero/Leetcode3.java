package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode3
 * @Author: markey
 * @Description:
 * @Date: 2020/6/26 10:02
 * @Version: 1.0
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            for (int i = start; i < end; i++) {
                if (s.charAt(i) == s.charAt(end)) {
                    start = i + 1;
                    break;
                }
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
