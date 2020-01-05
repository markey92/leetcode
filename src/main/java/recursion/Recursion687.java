package recursion;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: recursion
 * @ClassName: Recursion687
 * @Author: markey
 * @Description:
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/12/1 21:03
 * @Version: 1.0
 */
public class Recursion687 {
    /**
     * Runtime: 4 ms, faster than 76.02% of Java online submissions for Longest Univalue Path.
     * Memory Usage: 41.2 MB, less than 100.00% of Java online submissions for Longest Univalue Path.
     */
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        help(root);
        return max;
    }
    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);

        left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;

        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
