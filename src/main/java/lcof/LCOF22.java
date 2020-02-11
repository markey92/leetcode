package lcof;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF22
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 23:46
 * @Version: 1.0
 */
public class LCOF22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        return list.get(list.size() - k);
    }
}
