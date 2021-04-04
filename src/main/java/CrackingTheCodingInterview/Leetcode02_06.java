package CrackingTheCodingInterview;

import utils.ListNode;

import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode02_06
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 21:25
 * @Version: 1.0
 */
public class Leetcode02_06 {

    // 辅助链表。反转整个链表，需要额外空间
    public boolean isPalindrome1(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode temp = head;
        ListNode another = head;
        while (temp.next != null) {
            temp = temp.next;
            ListNode node = new ListNode(temp.val);
            node.next = another;
            another = node;
        }
        while (head != null) {
            if (head.val != another.val) {
                return false;
            }
            head = head.next;
            another = another.next;
        }
        return true;
    }
}
