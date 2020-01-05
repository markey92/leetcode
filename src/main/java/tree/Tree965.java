package tree;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree965
 * @Author: markey
 * @Description:
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：[2,2,2,5,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:58
 * @Version: 1.0
 */
public class Tree965 {
    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :35.2 MB, 在所有 java 提交中击败了77.86%的用户
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        return isValue(root.left, root.val) && isValue(root.right, root.val);
    }
    public boolean isValue(TreeNode root, int value) {
        if (root == null) {
            return true;
        }
        if (root.val != value) {
            return false;
        }
        return isValue(root.left, value) && isValue(root.right, value);
    }
}
