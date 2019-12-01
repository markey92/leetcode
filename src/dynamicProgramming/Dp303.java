package dynamicProgramming;

public class Dp303 {
    class NumArray {
        int[] sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sum[i] = nums[i];
                } else {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sum[j];
            } else {
                return sum[j] - sum[i-1];
            }
        }
    }
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    /**
     * Runtime: 52 ms, faster than 59.70% of Java online submissions for Range Sum Query - Immutable.
     * Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Range Sum Query - Immutable.
     */
//    class NumArray{
//        int[] sum;
//        public NumArray(int[] nums) {
//            sum = new int[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                if (i == 0) {
//                    sum[i] = nums[i];
//                } else {
//                    sum[i] = sum[i - 1] + nums[i];
//                }
//            }
//        }
//        public int sumRange(int i, int j) {
//            if (i == 0) {
//                return sum[j];
//            } else {
//                return sum[j] - sum[i-1];
//            }
//        }
//    }
}
