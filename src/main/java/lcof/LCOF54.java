package lcof;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF54
 * @Author: markey
 * @Description:
 * @Date: 2020/2/13 0:26
 * @Version: 1.0
 */
public class LCOF54 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);
        return list.get(k - 1);
    }

    public void helper(List list, TreeNode root) {
        if (root == null) {
            return ;
        }
        helper(list, root.right);
        list.add(root.val);
        helper(list, root.left);
    }
}
