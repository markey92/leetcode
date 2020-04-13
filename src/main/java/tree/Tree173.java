package tree;

import utils.TreeNode;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree173
 * @Author: markey
 * @Description:
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *  
 *
 * 示例：
 *
 *             7
 *            / \
 *          3    15
 *              /  \
 *             9    20
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/18 0:13
 * @Version: 1.0
 */
public class Tree173 {

    /**
     * 执行用时 :80 ms, 在所有 java 提交中击败了89.40%的用户
     * 内存消耗 :50.3 MB, 在所有 java 提交中击败了98.40%的用户
     */
    class BSTIterator {

        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }
        }

        /** @return the next smallest number */
        public int next() {
            if (!hasNext()) {
                return 0;
            }
            TreeNode treeNode = stack.pop();
            while (treeNode.left != null || treeNode.right != null) {
                if (treeNode.right != null) {
                    stack.push(treeNode.right);
                    treeNode.right = null;
                }
                stack.push(treeNode);
                if (treeNode.left != null) {
                    stack.push(treeNode.left);
                    treeNode.left = null;
                }
                treeNode = stack.pop();
            }
            return treeNode.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
