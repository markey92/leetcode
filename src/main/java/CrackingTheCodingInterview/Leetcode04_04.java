package CrackingTheCodingInterview;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode04_04
 * @Author: markey
 * @Description:
 * @Date: 2020/9/18 21:04
 * @Version: 1.0
 */
public class Leetcode04_04 {
    public boolean isBalanced(TreeNode root) {
        if (height(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
