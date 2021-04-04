package CrackingTheCodingInterview;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode02_05
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 21:12
 * @Version: 1.0
 */
public class Leetcode02_05 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry == 0 ? null : new ListNode(carry);
        }
        int val = carry;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(val % 10);
        node.next = addTwoNumbers(l1, l2, val / 10);
        return node;
    }
}
