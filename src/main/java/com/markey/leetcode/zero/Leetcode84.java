package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode84
 * @Author: markey
 * @Description:
 * @Date: 2020/10/7 10:49
 * @Version: 1.0
 */
public class Leetcode84 {

    // 方法1 两个单调栈，遍历每个柱子（固定高度），确认可能的最大面积
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int n = heights.length;
        int[] left = new int[n];
        left[0] = -1;
        // 求比某个柱子高的最左边柱子
        for (int i = 1; i < n; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                tmp = left[tmp]; // 这样可以减少遍历次数，用tmp--也可以，只是会增加遍历次数
            }
            left[i] = tmp;
        }
        // 求比某个柱子高的最右边柱子
        int[] right = new int[n];
        right[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < n && heights[tmp] >= heights[i]) {
                tmp = right[tmp];
            }
            right[i] = tmp;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}
