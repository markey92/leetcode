package lcof;

import utils.TreeNode;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF7
 * @Author: markey
 * @Description:面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/19 22:55
 * @Version: 1.0
 */
public class LCOF7 {
    /**
     * 递归做法
     * 根据前序遍历的第一个值来将中序遍历的数组非两组，正对应着左子树（x个值）和右子树的中序遍历(n-1-x个值)
     * 而前序遍历（除去第一个值）的前x个值正好是左子树的前序遍历
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index;
        for (index = 0; index < inorder.length; index++) {
            if (inorder[index] == root.val) {
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }
}
