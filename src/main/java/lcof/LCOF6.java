package lcof;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF6
 * @Author: markey
 * @Description:
 * @Date: 2020/2/11 22:19
 * @Version: 1.0
 */
public class LCOF6 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
