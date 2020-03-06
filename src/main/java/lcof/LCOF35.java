package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF35
 * @Author: markey
 * @Description:面试题35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/5 0:55
 * @Version: 1.0
 */
public class LCOF35 {
    /**
     * 解题思路
     * 方案1：
     *
     * 第一步：遍历老链表，构建正常的链表，用一个map记录p到new_p
     * 第二步：新老链表同步next移动，对比记录random指针。
     * p 1->2->3->4
     * map | | | |
     * new_p 1->2->3->4
     *
     * 需要借助O(n)的空间，时间复杂度为o(n)
     *
     * 方案2：
     *
     * 不需要借助O(n)的空间，时间复杂度为o(n)
     *
     * 老新链表交叉存储，奇数位置为老链表，偶数位置新链表复制前一个位置。
     *
     * 新链表random即为旧链表random的后一个位置。
     *
     * p1->p1'->p2->p2'->...->pn->pn'
     *
     * 作者：ai-bian-cheng-de-zhou-niao
     * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/liang-chong-jian-dan-de-jie-fa-si-lu-by-ai-bian-ch/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    // 方法2
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node root = head;
        // 处理next指针
        while (root != null) {
            Node copy = new Node(root.val);
            copy.next = root.next;
            root.next = copy;
            root = copy.next;
        }
        // 处理随机指针
        root = head;
        while (root != null ) {
            if (root.random != null) {
                root.next.random = root.random.next;
            }
            root = root.next.next;
        }

        root = head;
        Node res = root.next; // 复制链表的root

        // 拆分链表
        Node temp = root.next;
        root.next = temp.next;
        root = root.next;
        while (root != null) {
            temp.next = root.next;
            temp = temp.next;
            root.next = temp.next;
            root = root.next;
        }
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
