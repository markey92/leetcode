package recursion;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: recursion
 * @ClassName: Recursion783
 * @Author: markey
 * @Description:
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/12/1 21:05
 * @Version: 1.0
 */
public class Recursion783 {
    int min = Integer.MAX_VALUE;
    TreeNode pre;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return min;
        }
        min = Math.min(min, minDiffInBST(root.left));
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        min = Math.min(min, minDiffInBST(root.right));
        return min;
    }
}
