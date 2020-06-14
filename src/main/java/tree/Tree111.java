package tree;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree111
 * @Author: markey
 * @Description:
 * @Date: 2020/5/18 23:24
 * @Version: 1.0
 */
public class Tree111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 注意只有左右子节点都是null时，才算叶子节点
        int depthOfLeft = root.left == null ? Integer.MAX_VALUE : minDepth(root.left);
        int depthOfRight = root.right == null ? Integer.MAX_VALUE :minDepth(root.right);
        return Math.min(depthOfLeft, depthOfRight) + 1;
    }
}
