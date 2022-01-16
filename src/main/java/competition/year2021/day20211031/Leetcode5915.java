package competition.year2021.day20211031;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211031
 * @ClassName: Leetcode5915
 * @Author: markey
 * @Description:
 * @Date: 2021/10/31 21:04
 * @Version: 1.0
 */
public class Leetcode5915 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> targets = new ArrayList<>();
        int preVal = head.val;
        head = head.next;
        int i = 1;
        while (head != null && head.next != null) {
            if (head.val > preVal && head.val > head.next.val) {
                targets.add(i);
            }
            if (head.val < preVal && head.val < head.next.val) {
                targets.add(i);
            }
            i++;
            preVal = head.val;
            head = head.next;
        }
        if (targets.size() < 2) {
            return new int[]{-1, -1};
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j < targets.size(); j++) {
            min = Math.min(min, targets.get(j) - targets.get(j - 1));
        }
        return new int[] {min, targets.get(targets.size() - 1) - targets.get(0)};
    }
}
