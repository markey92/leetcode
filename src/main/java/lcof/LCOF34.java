package lcof;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF34
 * @Author: markey
 * @Description:面试题34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/28 21:54
 * @Version: 1.0
 */
public class LCOF34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        treeSum(root, parent, 0, sum, res);
        return res;
    }

    private void treeSum(TreeNode root, List<Integer> parent, int sum, int target, List<List<Integer>> res) {
        if (root != null) {
            parent.add(root.val);
            if (root.left == null && root.right == null && sum + root.val == target) {
                res.add(parent);
                return;
            }
            if (sum < target) {
                treeSum(root.left, new ArrayList<>(parent), sum + root.val, target, res);
                treeSum(root.right, new ArrayList<>(parent), sum + root.val, target, res);
            }
        }
    }
}
