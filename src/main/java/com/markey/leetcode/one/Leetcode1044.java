package com.markey.leetcode.one;

import java.util.HashSet;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode1044
 * @Author: markey
 * @Description:
 * @Date: 2021/12/23 22:08
 * @Version: 1.0
 */
public class Leetcode1044 {
    public static void main(String[] args) {
//        System.out.println();
        Leetcode1044 leetcode1044 = new Leetcode1044();
        System.out.println(leetcode1044.longestDupSubstring("nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy"));
    }
    long p = 31;
    public String longestDupSubstring(String s) {
        int start = 1;
        int end = s.length() - 1;
        int res = -1;
        int len = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int temp = find(s, mid);
            if (temp == -1) {
                end = mid - 1;
            } else {
                start = mid + 1;
                len = mid;
                res = temp;
            }
        }
        return res == -1 ? "" : s.substring(res - len + 1, res + 1);
    }

    private int find(String s, int n) {
        long hash = s.charAt(0) - 'a'; // p进制的数字 sub[0]*p^{m-1}+sub[1]*p^{m-2}...+sub[m-1]
        long pN = 1;
        for (int i = 1; i < n; i++) {
            hash = (hash * p + (s.charAt(i) - 'a'));
            pN = pN * p;
        }
        HashSet<Long> set = new HashSet<>();
        set.add(hash);
        for (int i = n; i < s.length(); i++) {
            // 遍历最后一个字符
            hash = (hash - (s.charAt(i - n) - 'a') * pN) * p + (s.charAt(i) - 'a');
            if (set.contains(hash)) {
                return i;
            }
            set.add(hash);
        }
        return -1;
    }
}
