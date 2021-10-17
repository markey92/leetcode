package com.markey.leetcode.eight;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.eight
 * @ClassName: Leetcode897
 * @Author: markey
 * @Description:
 * @Date: 2021/4/25 7:48
 * @Version: 1.0
 */
public class Leetcode897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            root.right = increasingBST(root.right);
            return root;
        }
        TreeNode left = increasingBST(root.left);
        TreeNode leftLast = left;
        while (leftLast.right != null) {
            leftLast = leftLast.right;
        }
        leftLast.right = root;
        root.left = null;
        root.right = increasingBST(root.right);
        return left;
    }
}
