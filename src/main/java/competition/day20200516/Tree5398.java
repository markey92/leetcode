package competition.day20200516;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200516
 * @ClassName: Tree5398
 * @Author: markey
 * @Description:
 * @Date: 2020/5/16 22:54
 * @Version: 1.0
 */
public class Tree5398 {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val >= max) {
            res++;
            max = root.val;
        }
        return res + goodNodes(root.left, max) + goodNodes(root.right, max);
    }
}
