package lcof;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF55_2
 * @Author: markey
 * @Description:面试题55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  
 *
 * 限制：
 *
 * 1 <= 树的结点个数 <= 10000
 * 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/20 22:57
 * @Version: 1.0
 */
public class LCOF55_2 {
    // 查询某个节点的树高度，如果左右不平衡就返回-1；如果左边或者右边是-1（不平衡），则也返回-1；
    // 最终root是-1就说明有某一个子树不平衡
    public boolean isBalanced(TreeNode root) {
        if (getDepth(root) == -1) {
            return false;
        }
        return true;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
