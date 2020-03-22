package competition.day20200202;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200202
 * @ClassName: Tree1339
 * @Author: markey
 * @Description:1339. 分裂二叉树的最大乘积
 * @Date: 2020/3/13 21:30
 * @Version: 1.0
 */
public class Tree1339 {
    /**
     * 先求出总和
     * 然后求每个子树和剩余子树的乘积最大值
     */
    long max = 0;
    public int maxProduct(TreeNode root) {
        int sum = sum(root);
        middleSearch(root, sum);
        return (int) (max % 1000000007);

    }

    private long middleSearch(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        long left = middleSearch(root.left, sum);
        long right = middleSearch(root.right, sum);

        long temp = left + right + root.val;
        max = Math.max(max, temp * (sum - temp));

        return temp;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
}
