package high_level.binary_indexed_tree;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: high_level.binary_indexed_tree
 * @ClassName: Leetcode307
 * @Author: markey
 * @Description:
 * @Date: 2020/11/4 22:18
 * @Version: 1.0
 */
public class Leetcode307 {
    class NumArray {
        int[] nums;
        int[] C;
        public NumArray(int[] nums) {
            int n = nums.length;
            this.nums = new int[n];
            this.C = new int[n + 1];
            for (int i = 0; i < nums.length; i++) {
                update(i, nums[i]);
            }
        }

        public void update(int i, int val) {
            int diff = val - nums[i];
            add(C, i + 1, diff);
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            System.out.println(Arrays.toString(C));
            return query(C, j + 1) - query(C, i);
        }

        private int query(int[] C, int i) {
            int sum = 0;
            while (i > 0) {
                sum += C[i];
                i -= lowBit(i);
            }
            return sum;
        }
        private void add(int[] C, int i, int val) {
            while (i < C.length) {
                C[i] += val;
                i += lowBit(i);
            }
        }

        private int lowBit(int n) {
            return n & (-n);
        }
    }
}
