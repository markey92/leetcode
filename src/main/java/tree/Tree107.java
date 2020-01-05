package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree107
 * @Author: markey
 * @Description:
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:48
 * @Version: 1.0
 */
public class Tree107 {
    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :36.4 MB, 在所有 java 提交中击败了40.60%的用户
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        addToList(res, 0, root);
        Collections.reverse(res);
        return res;
    }
    public void addToList(List<List<Integer>> list, int level, TreeNode root) {
        if (root == null) {
            return;
        }
        if (list.size() <= level || list.get(level) == null) {
            list.add(level, new ArrayList<>());
        }
        list.get(level).add(root.val);
        addToList(list, level+1, root.left);
        addToList(list, level+1, root.right);
    }
}
