package tree;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree404
 * @Author: markey
 * @Description:
 * @Date: 2020/2/8 22:46
 * @Version: 1.0
 */
public class Tree404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }
}

