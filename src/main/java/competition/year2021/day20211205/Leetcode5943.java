package competition.year2021.day20211205;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211205
 * @ClassName: Leetcode5943
 * @Author: markey
 * @Description:
 * @Date: 2021/12/5 10:40
 * @Version: 1.0
 */
public class Leetcode5943 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode preLow = preHead;
        while (fast != null  && fast.next != null) {
            fast = fast.next.next;
            preLow = low;
            low = low.next;
        }
        preLow.next = low.next;
        return preHead.next;
    }
}
