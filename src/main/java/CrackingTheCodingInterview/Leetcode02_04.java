package CrackingTheCodingInterview;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode02_04
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 20:54
 * @Version: 1.0
 */
public class Leetcode02_04 {

    // 头插法
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode preNode = head;
        while (node != null) {
            if (node.val < x) {
                preNode.next = node.next;
                node.next = head;
                head = node;
                node = preNode.next;
            } else {
                preNode = node;
                node = preNode.next;
            }
        }
        return head;
    }
    // 交换法
    public ListNode partition1(ListNode head, int x) {
        ListNode res = head;
        while (head != null) {
            if (head.val < x) {
                head = head.next;
                continue;
            }
            ListNode small = head.next;
            while (small != null && small.val >= x) {
                small = small.next;
            }
            if (small != null) {
                int temp = head.val;
                head.val = small.val;
                small.val = temp;
            } else {
                break;
            }
            head = head.next;
        }
        return res;
    }
}
