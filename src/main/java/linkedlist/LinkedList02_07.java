package linkedlist;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: linkedlist
 * @ClassName: LinkedList02_07
 * @Author: markey
 * @Description:
 * @Date: 2020/5/23 22:38
 * @Version: 1.0
 */
public class LinkedList02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA != null) {
                nodeA = nodeA.next;
            } else {
                nodeA = headB;
            }
            if (nodeB != null) {
                nodeB = nodeB.next;
            } else {
                nodeB = headA;
            }
        }
        return nodeA;
    }
}
