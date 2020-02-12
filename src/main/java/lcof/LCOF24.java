package lcof;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF24
 * @Author: markey
 * @Description:
 * @Date: 2020/2/12 23:26
 * @Version: 1.0
 */
public class LCOF24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode preNode = head.next;
        head.next = null;
        ListNode temp;
        while (preNode != null) {
            temp = preNode.next;
            preNode.next = head;
            head = preNode;
            preNode = temp;
        }
        return head;
    }
}
