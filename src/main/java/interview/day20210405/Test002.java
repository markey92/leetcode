package interview.day20210405;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20210405
 * @ClassName: Test002
 * @Author: markey
 * @Description:
 * @Date: 2021/4/5 12:08
 * @Version: 1.0
 */
public class Test002 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        count(preHead, head, n);
        return preHead.next;
    }

    public int count(ListNode pre, ListNode node, int n) {
        if (node == null) {
            return 0;



        }
        int count = count(node, node.next, n) + 1;
        if (count == n) {
            pre.next = node.next;
        }
        return count;
    }
}
