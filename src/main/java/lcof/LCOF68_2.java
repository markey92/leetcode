package lcof;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF68_2
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 23:04
 * @Version: 1.0
 */
public class LCOF68_2 {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return res;
    }

    private int find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == p.val || root.val == q.val) {
            count++;
        }
        count += find(root.left, p, q);
        count += find(root.right, p, q);
        if (count >= 2 && res == null) {
            res = root;
        }
        return count;
    }
}
