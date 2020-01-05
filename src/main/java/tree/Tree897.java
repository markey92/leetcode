package tree;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree897
 * @Author: markey
 * @Description:
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *  
 *
 * 提示：
 *
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:57
 * @Version: 1.0
 */
public class Tree897 {
    /**
     * 执行用时 :3 ms, 在所有 java 提交中击败了93.94%的用户
     * 内存消耗 :43.4 MB, 在所有 java 提交中击败了93.50%的用户
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null) {
            TreeNode tmp = new TreeNode(root.val);
            tmp.right = increasingBST(root.right);
            return tmp;
        }
        TreeNode res = increasingBST(root.left);
        TreeNode tmp = res;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        tmp.right = root;
        root.left = null;
        root.right = increasingBST(root.right);
        return res;
    }
}
