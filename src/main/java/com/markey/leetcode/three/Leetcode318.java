package com.markey.leetcode.three;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode318
 * @Author: markey
 * @Description:
 * @Date: 2021/8/2 21:02
 * @Version: 1.0
 */
public class Leetcode318 {
    public int maxProduct(String[] words) {
        int n = words.length;
        // 转成二进制，二进制比较存在相同字母时，可用与运算，复杂度1
        int[] wordBins = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                wordBins[i] = wordBins[i] | 1 << (c - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((wordBins[i] & wordBins[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
