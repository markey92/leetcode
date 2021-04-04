package CrackingTheCodingInterview;

import org.omg.CORBA.INTERNAL;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode04_09
 * @Author: markey
 * @Description:
 * @Date: 2020/9/23 21:00
 * @Version: 1.0
 */
public class Leetcode04_09 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<TreeNode> items = new ArrayList<>();
        if (root != null) {
            items.add(root);
        }
        List<Integer> tmpRes = new ArrayList<>();
        dfs(items, tmpRes);
        return res;
    }
    private void dfs(List<TreeNode> items, List<Integer> tmpRes) {
        if (items.isEmpty()) {
            res.add(new ArrayList<>(tmpRes));
        }
        int len = items.size();
        for (int i = 0; i < len; i++) {
            TreeNode item = items.remove(i);
            if (item.left != null) {
                items.add(item.left);
            }
            if (item.right != null) {
                items.add(item.right);
            }
            tmpRes.add(item.val);
            dfs(items, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
            if (item.left != null) {
                items.remove(item.left);
            }
            if (item.right != null) {
                items.remove(item.right);
            }
            items.add(i, item);
        }
    }
}
