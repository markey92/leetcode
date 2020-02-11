package lcof;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: swordFingerOffer
 * @ClassName: Sword55
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 22:00
 * @Version: 1.0
 */
public class LCOF55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
