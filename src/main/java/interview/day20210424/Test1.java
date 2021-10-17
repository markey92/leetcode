package interview.day20210424;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20210424
 * @ClassName: Test1
 * @Author: markey
 * @Description:
 * @Date: 2021/4/24 11:08
 * @Version: 1.0
 */
public class Test1 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        findTarget(root, target, K);
        return res;
    }

    private int findTarget(TreeNode node, TreeNode target, int K) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (node.val == target.val) {
            addResult(node, K);
            return 0;
        }

        int left = findTarget(node.left, target, K);
        if (left + 1 == K) {
            res.add(node.val);
        } else if (left >= 0 && left + 1 < K) {
            addResult(node.right, K - left - 2);
        }

        int right = findTarget(node.right, target, K);
        if (right + 1 == K) {
            res.add(node.val);
        } else if (right >= 0 && right + 1 < K) {
            addResult(node.left, K - right - 2);
        }
        return Math.max(left + 1, right + 1);
    }

    private void addResult(TreeNode root, int K) {
        if (root == null || K < 0) {
            return;
        }
        if (K == 0) {
            res.add(root.val);
        }
        addResult(root.left, K -1);
        addResult(root.right, K - 1);
    }
}
