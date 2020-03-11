package competition.day20200307;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200307
 * @ClassName: Tree5338
 * @Author: markey
 * @Description:
 * @Date: 2020/3/7 22:51
 * @Version: 1.0
 */
public class Tree5338 {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        longestZigZag(root.left, 0, true);
        longestZigZag(root.right, 0, false);
        return max;
    }

    public void longestZigZag(TreeNode root, int parent, boolean left) {
        if (root == null) {
            max = Math.max(max, parent);
            return;
        }
        if (left) {
            longestZigZag(root.left, 0, true);
            longestZigZag(root.right, parent + 1, false);
        } else {
            longestZigZag(root.left, parent + 1, true);
            longestZigZag(root.right, 0, false);
        }
    }
}
