package high_level.segment_tree;

/**
 * @ProjectName: leetcode
 * @Package: high_level.segment_tree
 * @ClassName: Leetcode307
 * @Author: markey
 * @Description:
 * @Date: 2020/11/8 22:33
 * @Version: 1.0
 */
public class Leetcode307 {
    class NumArray {
//        SegmentTree root;
//        public NumArray(int[] nums) {
//            root = buildTree(nums, 0, nums.length - 1);
//        }
//
//        public void update(int i, int val) {
//            this.root.update(i, val);
//        }
//
//        public int sumRange(int i, int j) {
//            return root.querySum(i, j);
//        }
//
//        private SegmentTree buildTree(int[] nums, int start, int end) {
//            if (start > end) {
//                return null;
//            }
//            SegmentTree node = new SegmentTree(start, end);
//            if (start == end) {
//                node.val = nums[start];
//            } else {
//                int mid = start + (end - start) / 2;
//                node.left = buildTree(nums, start, mid);
//                node.right = buildTree(nums, mid + 1, end);
//                node.val = node.left.val + node.right.val;
//            }
//            return node;
//        }

        class SegmentTree {
            int start, end, val;
            SegmentTree left, right;

            public SegmentTree(int start, int end) {
                this.start = start;
                this.end = end;
                this.val = 0;
            }

            public void update(int i, int val) {
                if (start == end) {
                    // 这种情况肯定等于i
                    this.val = val;
                    return;
                }
                int mid = start + (end - start) / 2;
                if (i <= mid) {
                    this.left.update(i, val);
                } else {
                    this.right.update(i, val);
                }
                this.val = this.left.val + this.right.val;
            }

            public int querySum(int i, int j) {
                if (start == i && end == j) {
                    return this.val;
                }
                int mid = start + (end - start) / 2;
                if (j <= mid) {
                    return this.left.querySum(i, j);
                } else if (i > mid) {
                    return this.right.querySum(i, j);
                } else {
                    return this.left.querySum(i, mid) + this.right.querySum(mid + 1, j);
                }
            }
        }
    }


}
