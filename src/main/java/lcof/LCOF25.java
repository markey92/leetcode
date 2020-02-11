package lcof;

import utils.ListNode;


/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF25
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 23:35
 * @Version: 1.0
 */
public class LCOF25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res, next;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            res = l2;
            l2 = l2.next;
        } else {
            res = l1;
            l1 = l1.next;
        }

        next = res;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                next.next = l2;
                l2 = l2.next;
                next = next.next;
                continue;
            }

            if (l2 == null) {
                next.next = l1;
                l1 = l1.next;
                next = next.next;
                continue;
            }

            if (l1.val < l2.val) {
                next.next = l1;
                l1 = l1.next;
                next = next.next;
                continue;
            } else {
                next.next = l2;
                l2 = l2.next;
                next = next.next;
                continue;
            }

        }
        return res;
    }
}
