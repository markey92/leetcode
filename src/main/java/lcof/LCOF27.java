package lcof;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF27
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 22:15
 * @Version: 1.0
 */
public class LCOF27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(node);
        return root;
    }
}
