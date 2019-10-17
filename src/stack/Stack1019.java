package stack;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack1019
 * @Author: markey
 * @Description:
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *  
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/18 0:30
 * @Version: 1.0
 */
public class Stack1019 {

    /**
     * 执行用时 :80 ms, 在所有 java 提交中击败了53.25%的用户
     * 内存消耗 :41.1 MB, 在所有 java 提交中击败了98.43%的用户
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> input = new Stack<>();
        int size = 0;
        while (head != null) {
            size ++;
            input.push(head.val);
            head = head.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[size];
        while (!input.isEmpty()) {
            size--;
            while (!stack.isEmpty() && input.peek() >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[size] = 0;
            } else {
                result[size] = stack.peek();
            }
            stack.push(input.pop());
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
