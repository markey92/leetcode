package linkedlist;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: linkedlist
 * @ClassName: LinkedList02_01
 * @Author: markey
 * @Description:
 * @Date: 2020/5/28 21:38
 * @Version: 1.0
 */
public class LinkedList02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        Set<Integer> set = new HashSet<>();
        while (head != null && head.next != null) {
            set.add(head.val);
            if (set.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return pre.next;
    }
}
