package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: linkedlist
 * @ClassName: LinkedList138
 * @Author: markey
 * @Description:138. 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/19 18:33
 * @Version: 1.0
 */
public class LinkedList138 {
    // 还有另一种方法就是再原链表上复制，最后再分离出来

    // 暴力两次遍历
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(null, null);
        Node newHead = new Node(0);
        Node newNode = newHead;
        Node oldNode = head;
        while (oldNode != null) {
            newNode.next = new Node(oldNode.val);
            newNode = newNode.next;
            nodeMap.put(oldNode, newNode);
            oldNode = oldNode.next;
        }
        oldNode = head;
        while (oldNode != null) {
            nodeMap.get(oldNode).random = nodeMap.get(oldNode.random);
            oldNode = oldNode.next;
        }
        return newHead.next;
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
