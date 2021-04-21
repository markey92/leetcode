package competition.day20210411;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210411
 * @ClassName: Leetcode5727
 * @Author: markey
 * @Description:
 * @Date: 2021/4/11 10:33
 * @Version: 1.0
 */
public class Leetcode5727 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}
