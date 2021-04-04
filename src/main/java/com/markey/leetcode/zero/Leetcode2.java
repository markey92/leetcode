package com.markey.leetcode.zero;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode2
 * @Author: markey
 * @Description:
 * @Date: 2020/6/26 10:12
 * @Version: 1.0
 */
public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode pre = result;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode now = new ListNode(carry % 10);
            carry /= 10;
            pre.next = now;
            pre = now;
        }
        return result.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode result = new ListNode(sum);
        ListNode node = result;
        for(int i = 0; null!=l1 || null!=l2 || sum!=0; i++){
            if(i!=0){
                node.next = new ListNode(0);
                node=node.next;
            }
            if(null!=l1){
                sum += l1.val;
                l1 = l1.next;
            }
            if(null!=l2){
                sum += l2.val;
                l2 = l2.next;
            }
            node.val = sum%10;
            sum = sum/10;
        }
        return result;

    }
}
