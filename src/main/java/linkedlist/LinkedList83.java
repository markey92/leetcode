package linkedlist;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: linkedlist
 * @ClassName: LinkedList83
 * @Author: markey
 * @Description:
 * @Date: 2020/5/18 23:21
 * @Version: 1.0
 */
public class LinkedList83 {
    // 用一个preHead来保存头节点，这是一个常见操作
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        while (head != null && head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return preHead.next;
    }
}
