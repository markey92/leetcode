package competition.year2021.day20210530;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210530
 * @ClassName: Leetcode5774
 * @Author: markey
 * @Description:
 * @Date: 2021/5/30 10:49
 * @Version: 1.0
 */
public class Leetcode5774 {
    public static void main(String[] args) {
        System.out.println(assignTasks(new int[] {3,3,2},
                new int[] {1,2,3,2,1,2}));
        ;
    }
    public static int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;

        // 0 是空闲时间点， 1 优先权重 2 序号
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> queue1 = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{0, servers[i], i});
        }
        int[] res = new int[tasks.length];
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);
            while (!queue.isEmpty() && queue.peek()[0] <= time) {
                queue1.add(queue.poll());
            }
            if (queue1.isEmpty()) {
                time = queue.peek()[0];
                while (!queue.isEmpty() && queue.peek()[0] <= time) {
                    queue1.add(queue.poll());
                }
            }
            int[] server = queue1.poll();
            res[i] = server[2];
            queue.add(new int[]{time + tasks[i], server[1], server[2]});
        }
        return res;
    }
}
