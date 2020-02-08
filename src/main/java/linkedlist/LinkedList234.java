package linkedlist;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: linkedlist
 * @ClassName: LinkedList234
 * @Author: markey
 * @Description:
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * @Date: 2020/2/8 19:16
 * @Version: 1.0
 */
public class LinkedList234 {
    /**
     * 转成数组
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0, end = list.size() - 1;
        while (start < end) {
            if (list.get(start) - list.get(end) == 0) {
                start++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }
}
