package competition.year2020.day20201004;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201004
 * @ClassName: Leetcode1609
 * @Author: markey
 * @Description:
 * @Date: 2020/10/7 17:13
 * @Version: 1.0
 */
public class Leetcode1609 {
    // BFS
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int level = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            TreeNode lastNode;
            if (level % 2 == 1) {
                lastNode = new TreeNode(Integer.MIN_VALUE);
            } else {
                lastNode = new TreeNode(Integer.MAX_VALUE);
            }

            for (int i = 0; i < size; i++) {
                // 遍历判断结果
                TreeNode now = deque.removeFirst();
                if (level % 2 == 1) {
                    // 奇数层
                    if (now.val % 2 != 1) {
                        return false;
                    }
                    if (now.val <= lastNode.val) {
                        return false;
                    }
                } else {
                    if (now.val % 2 != 0) {
                        return false;
                    }
                    if (now.val >= lastNode.val) {
                        return false;
                    }
                }
                lastNode = now;

                // 插入下一层节点
                if (now.left != null) {
                    deque.addLast(now.left);
                }
                if (now.right != null) {
                    deque.addLast(now.right);
                }
            }
            level++;
        }
        return true;
    }
}
