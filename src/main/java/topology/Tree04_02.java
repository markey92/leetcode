package topology;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: topology
 * @ClassName: Tree04_02
 * @Author: markey
 * @Description:
 * @Date: 2020/6/1 21:34
 * @Version: 1.0
 */
public class Tree04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
