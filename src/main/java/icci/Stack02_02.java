package icci;

import utils.ListNode;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: icci
 * @ClassName: Stack02_02
 * @Author: markey
 * @Description:
 * @Date: 2020/3/3 23:55
 * @Version: 1.0
 */
public class Stack02_02 {
    public int kthToLast(ListNode head, int k) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = stack.pop();
        }
        return res;
    }
}
