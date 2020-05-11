package stack;

import utils.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack23
 * @Author: markey
 * @Description:23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/26 21:31
 * @Version: 1.0
 */
public class Stack23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        Arrays.stream(lists).filter(Objects::nonNull).forEach(node -> heap.offer(node));
        ListNode preHead = new ListNode(0);
        ListNode head = preHead;
        while (!heap.isEmpty()) {
            head.next = heap.poll();
            head = head.next;
            if (head.next != null) {
                heap.offer(head.next);
            }
        }
        return preHead.next;
    }
}
