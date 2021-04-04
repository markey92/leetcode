package CrackingTheCodingInterview;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode04_05
 * @Author: markey
 * @Description:
 * @Date: 2020/9/18 21:10
 * @Version: 1.0
 */
public class Leetcode04_05 {
    long preNode = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && !isValidBST(root.left)) {
            return false;
        }
        if (root.val < preNode) {
            return false;
        } else {
            preNode = root.val;
        }
        if (root.right != null && !isValidBST(root.right)) {
            return false;
        }
        return true;
    }

}
