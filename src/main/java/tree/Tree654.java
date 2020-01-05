package tree;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: tree
 * @ClassName: Tree654
 * @Author: markey
 * @Description:
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *  
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:54
 * @Version: 1.0
 */
public class Tree654 {
    /**
     * Runtime: 2 ms, faster than 99.75% of Java online submissions for Maximum Binary Tree.
     * Memory Usage: 39.2 MB, less than 82.61% of Java online submissions for Maximum Binary Tree.
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            root = insert(root, nums[i]);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }
        if (num > root.val) {
            TreeNode temp = new TreeNode(num);
            temp.left = root;
            root = temp;
        } else {
            root.right = insert(root.right, num);
        }
        return root;
    }
}
