package lcof;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF68_2
 * @Author: markey
 * @Description:面试题68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/11 23:04
 * @Version: 1.0
 */
public class LCOF68_2 {
    /**
     * 如果题目没有说所有值都是唯一的，那么这种算法可能不会得到最深的那个公共祖先
     * 可以考虑递归参数中再加一个参数，表示层级
     */
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return res;
    }

    private int find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == p.val || root.val == q.val) {
            count++;
        }
        count += find(root.left, p, q);
        count += find(root.right, p, q);
        if (count >= 2 && res == null) {
            res = root;
        }
        return count;
    }
}
