package competition.day20210110;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210110
 * @ClassName: Leetcode5652
 * @Author: markey
 * @Description:
 * @Date: 2021/1/10 10:33
 * @Version: 1.0
 */
public class Leetcode5652 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        ListNode pre = null, last = null;
        node = head;
        for (int i = 1; i < count + 1; i++) {
            if (i == k) {
                pre = node;
            }
            if (i == count - k + 1) {
                last = node;
            }
            node = node.next;
        }
        if (pre != last) {
            pre.val += last.val;
            last.val = pre.val - last.val;
            pre.val = pre.val - last.val;
        }
        return head;
    }
}
