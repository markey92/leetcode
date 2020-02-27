package lcof;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF26
 * @Author: markey
 * @Description:面试题26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/26 23:30
 * @Version: 1.0
 */
public class LCOF26 {
    /**
     * 遍历A的每个节点：判断A和B的根是否相同，是：判断A和B是不是相同树，否：判断B是不是A.left或者A.right的子树
     * 判断A和B是不是相同树（因为判断过根是否相同，所以A和B肯定不为null）：
     * 1：A.val == B.val，递归判断A.left和B.left ，A.righ和B.right是否相同
     * 2：如果B == null（递归过程中，非根情况），说明没有需要判断的子节点了，A和B是相同结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A != null && B != null && A.val == B.val) {
            if (isSame(A, B)) {
                return true;
            }
        }

        if (A != null) {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        return false;
    }

    private boolean isSame(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A != null && A.val == B.val) {
            return isSame(A.left, B.left) && isSame(A.right, B.right);
        }
        return false;
    }
}
