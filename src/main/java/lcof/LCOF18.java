package lcof;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF18
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 22:33
 * @Version: 1.0
 */
public class LCOF18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode(head.next, val);
        return head;
    }
}
