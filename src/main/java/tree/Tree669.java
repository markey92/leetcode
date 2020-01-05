package tree;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree669
 * @Author: markey
 * @Description:
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 示例 1:
 *
 * 输入:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * 输出:
 *     1
 *       \
 *        2
 * 示例 2:
 *
 * 输入:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * 输出:
 *       3
 *      /
 *    2
 *   /
 *  1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:56
 * @Version: 1.0
 */
public class Tree669 {
    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.6 MB, 在所有 java 提交中击败了94.76%的用户
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }
}
