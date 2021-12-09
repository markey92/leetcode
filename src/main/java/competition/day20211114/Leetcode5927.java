package competition.day20211114;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211114
 * @ClassName: Leetcode5927
 * @Author: markey
 * @Description:
 * @Date: 2021/11/14 10:37
 * @Version: 1.0
 */
public class Leetcode5927 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode res = head;
        List<ListNode> nodes = new ArrayList<>();
        do {
            nodes.add(head);
            head = head.next;
        } while (head != null);
        int fast = -1;
        int low = 0;
        int step = 0;
        while ((low + step) < nodes.size()) {
            low += step;
            fast += step + 1;
            step++;
            reverseNodes(nodes, low, fast);
        }
        return res;
    }

    private void reverseNodes(List<ListNode> nodes, int start, int end) {
        end = Math.min(end, nodes.size() - 1);
        if ((end - start) % 2 == 0) {
            while (start < end) {
                int temp = nodes.get(start).val;
                nodes.get(start).val = nodes.get(end).val;
                nodes.get(end).val = temp;
                start++;
                end--;
            }
        }
    }
}
