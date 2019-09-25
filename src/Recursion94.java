/**
 * 给定一个二叉树，返回它的中序 遍历。Given a binary tree, return the inorder traversal of its nodes' values.
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Recursion94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list = getOrderList(root);
        }
        return list;
    }

    public List<Integer> getOrderList(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node.left != null) {
            result.addAll(getOrderList(node.left));
        }
        result.add(node.val);
        if (node.right != null) {
            result.addAll(getOrderList(node.right));
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
