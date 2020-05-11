package linkedlist;

import utils.ListNode;

import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: linkedlist
 * @ClassName: LinkedList61
 * @Author: markey
 * @Description:61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/19 18:49
 * @Version: 1.0
 */
public class LinkedList61 {
    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count ++;
            if (node.next == null) {
                // 到达链表尾部,并将链表首位相连
                node.next = head;
                break;
            } else {
                node = node.next;
            }

        }
        // 链表没有值的特殊情况
        if (count == 0) {
            return head;
        }
        // 因为移动cout位相当于没有移动
        k = k % count;

        // 直接找到移动后的head，并将其前一个node的next置为null
        ListNode newHead = head, preHead = null;
        for (int i = 0; i < count - k; i++) {
            preHead = newHead;
            newHead = newHead.next;
        }
        preHead.next = null;
        return newHead;
    }
}
