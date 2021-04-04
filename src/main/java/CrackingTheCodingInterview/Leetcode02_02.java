package CrackingTheCodingInterview;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode02_02
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 18:07
 * @Version: 1.0
 */
public class Leetcode02_02 {
    // 快慢指针
    public int kthToLast2(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    // 递归计数
    int target;
    public int kthToLast(ListNode head, int k) {
        help(head, k);
        return target;
    }

    public int help(ListNode head, int k) {
        int res = 0;
        if (head.next == null) {
            res = 1;
        } else {
            res = help(head.next, k) + 1;
        }
        if (res == k) {
            target = head.val;
        }
        return res;
    }
}
