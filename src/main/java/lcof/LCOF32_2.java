package lcof;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF32_2
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 23:25
 * @Version: 1.0
 */
public class LCOF32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int num = nodes.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                TreeNode node = nodes.get(0);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                list.add(node.val);
                nodes.remove(node);
            }
            res.add(list);
        }
        return res;
    }
}
