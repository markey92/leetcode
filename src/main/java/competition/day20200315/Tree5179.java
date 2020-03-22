package competition.day20200315;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200315
 * @ClassName: Tree5179
 * @Author: markey
 * @Description:
 * @Date: 2020/3/15 11:03
 * @Version: 1.0
 */
public class Tree5179 {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        // 中序遍历获取所有的值
        middleSearch(values, root);
        // 重新生成二叉搜索树
        return bst(values, 0, values.size());
    }

    private TreeNode bst(List<Integer> list, int start, int end) {
        if (start >= end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(middle));
        root.left = bst(list, start, middle);
        root.right = bst(list, middle + 1, end);
        return root;
    }
    private void middleSearch(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        middleSearch(list, root.left);
        list.add(root.val);
        middleSearch(list, root.right);
    }
}
