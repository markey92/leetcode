package linkedlist;

import utils.ListNode;

/**
 * @ProjectName: leetcode
 * @Package: linkedlist
 * @ClassName: LinkedList02_03
 * @Author: markey
 * @Description:面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * 示例：
 *
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 * @Date: 2020/5/21 23:39
 * @Version: 1.0
 */
public class LinkedList02_03 {
    public void deleteNode(ListNode node) {
        ListNode preNode = node;
        while (node.next != null) {
            node.val = node.next.val;
            preNode = node;
            node = node.next;
        }
        preNode.next = null;
    }
}
