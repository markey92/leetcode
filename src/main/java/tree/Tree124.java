package tree;

import utils.TreeNode;

import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree124
 * @Author: markey
 * @Description:
 * @Date: 2020/6/21 20:55
 * @Version: 1.0
 */
public class Tree124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        if (left < 0) {
            left = 0;
        }
        int right = dfs(root.right);
        if (right < 0) {
            right = 0;
        }
        max = Math.max(left + right + root.val, max);
        return root.val + Math.max(left, right);
    }
}
