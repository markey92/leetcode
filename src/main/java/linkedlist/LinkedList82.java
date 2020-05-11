package linkedlist;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: linkedlist
 * @ClassName: LinkedList82
 * @Author: markey
 * @Description:82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/5 19:28
 * @Version: 1.0
 */
public class LinkedList82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(Integer.MAX_VALUE);
        preHead.next = head;
        head = preHead;
        
        while (head.next != null) {
            ListNode next = head.next;
            boolean ifSame = false;
            while (next.next != null) {
                if (next.val == next.next.val) {
                    next.next = next.next.next;
                    ifSame = true;
                } else {
                    break;
                }
            }
            if (ifSame) {
                head.next = next.next;
            } else {
                head.next = next;
            }
            head = next;
        }
        return preHead.next;
    }
}
