package CrackingTheCodingInterview;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode04_03
 * @Author: markey
 * @Description:
 * @Date: 2020/9/18 20:52
 * @Version: 1.0
 */
public class Leetcode04_03 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[]{};
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(tree);
        List<ListNode> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            ListNode preHead = new ListNode(0);
            ListNode head = preHead;
            for (int i = 0; i < size; i++) {
                TreeNode now = deque.pollFirst();
                head.next = new ListNode(now.val);
                head = head.next;
                if (now.left != null) {
                    deque.addLast(now.left);
                }
                if (now.right != null) {
                    deque.addLast(now.right);
                }
            }
            res.add(preHead.next);
        }
        return res.toArray(new ListNode[0]);
    }
}
