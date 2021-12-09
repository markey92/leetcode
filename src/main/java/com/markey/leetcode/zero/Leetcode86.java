package com.markey.leetcode.zero;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.zero
 * @ClassName: Leetcode86
 * @Author: markey
 * @Description:
 * @Date: 2021/10/23 17:40
 * @Version: 1.0
 */
public class Leetcode86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallHead = small;
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
