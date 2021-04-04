package com.markey.leetcode.three;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode327
 * @Author: markey
 * @Description:
 * @Date: 2020/10/30 22:06
 * @Version: 1.0
 */
public class Leetcode327 {
    // 树状数组模板题
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        // 前缀和
        int sum = 0;
        int[] sums = new int[n];
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i] = sum;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        // 树状数组不能有负数
        if (min < 0) {
            max -= min;
            for (int i = 0; i < n; i++) {
                sums[i] -= min;
            }
        }

        // 构造树状数组
        int res = 0;
        TreeArray treeArray = new TreeArray(Math.max(max + 1, max + upper));
        for (int i = 0; i < n; i++) {
            res += treeArray.query(sums[i] + upper + 1) - treeArray.query(sums[i] - lower);
            treeArray.add(sums[i] + 1);
        }
        return res;
    }

    private class TreeArray {
        int n;
        int[] C;

        public TreeArray(int n) {
            this.n = n;
            this.C = new int[n];
        }

        private int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += C[i];
                i -= lowBit(i);
            }
            return sum;
        }
        private void add(int i) {
            while (i < n) {
                C[i] += 1;
                i += lowBit(i);
            }
        }

        private int lowBit(int x) {
            return x & -x;
        }
    }
}
