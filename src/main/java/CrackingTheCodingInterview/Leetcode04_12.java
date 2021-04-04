package CrackingTheCodingInterview;

import utils.TreeNode;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode04_12
 * @Author: markey
 * @Description:
 * @Date: 2020/9/26 23:08
 * @Version: 1.0
 */
public class Leetcode04_12 {
    /**
     * 暴力遍历，居然没超时
     */
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            res++;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
}
