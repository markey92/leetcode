package CrackingTheCodingInterview;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode04_06
 * @Author: markey
 * @Description:
 * @Date: 2020/9/18 22:09
 * @Version: 1.0
 */
public class Leetcode04_06 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 分析左右，中序遍历
        if (root == null || p == null) {
            return null;
        }
        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}
