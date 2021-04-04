package com.markey.leetcode.three;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode307
 * @Author: markey
 * @Description:
 * @Date: 2020/10/30 21:25
 * @Version: 1.0
 */
public class Leetcode307 {
    // 树状数组模板题
    class NumArray {
        int[] C;
        int[] nums;
        int n;

        private void add(int i, int val) {
            while (i < C.length) {
                C[i] += val;
                i += lowBit(i);
            }
        }

        private int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += C[i];
                i -= lowBit(i);
            }
            return sum;
        }

        private int lowBit(int n) {
            return n & (-n);
        }

        public NumArray(int[] nums) {
            this.nums = nums;
            n = nums.length;
            C = new int[n + 1];
            for (int i = 0; i < n; i++) {
                add(i + 1, nums[i]);
            }
        }

        public void update(int i, int val) {
            int diff = val - nums[i];
            add(i + 1, diff);
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            return query(j + 1) - query(i);
        }
    }
}
