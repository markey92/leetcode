package tree;

import utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree105
 * @Author: markey
 * @Description:105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
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
 * 通过次数55,782提交次数86,176
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/5 22:45
 * @Version: 1.0
 */
public class Tree105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[0]);
        int headIndex = 0;
        for (headIndex = 0; headIndex < inorder.length; headIndex++) {
            if (inorder[headIndex] == head.val) {
                break;
            }
        }
        head.left = buildTree(Arrays.copyOfRange(preorder, 1, headIndex + 1),
                Arrays.copyOfRange(inorder, 0, headIndex));
        head.right = buildTree(Arrays.copyOfRange(preorder, headIndex + 1, preorder.length),
                Arrays.copyOfRange(inorder, headIndex + 1, inorder.length));
        return head;
    }
}
