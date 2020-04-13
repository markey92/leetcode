package tree;

import utils.TreeNode;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree106
 * @Author: markey
 * @Description:106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 通过次数30,110提交次数44,484
 * @Date: 2020/4/5 22:34
 * @Version: 1.0
 */
public class Tree106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[postorder.length - 1]);
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == head.val) {
                break;
            }
        }
        head.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        head.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
        return head;
    }
}
