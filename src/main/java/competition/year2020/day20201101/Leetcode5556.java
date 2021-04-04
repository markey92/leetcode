package competition.year2020.day20201101;

import java.util.PriorityQueue;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201101
 * @ClassName: Leetcode5556
 * @Author: markey
 * @Description:
 * @Date: 2020/11/1 11:13
 * @Version: 1.0
 */
public class Leetcode5556 {
    public static void main(String[] args) {
        int[] heights = new int[]{14,3,19,3};
        int bricks = 17;
        int ladders = 0;
        System.out.println(furthestBuilding(heights, bricks, ladders));
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> hasUsedBricks = new PriorityQueue();
        int now = 0;
        while (now < heights.length - 1) {
            int diff = heights[now + 1] - heights[now];
            if (diff <= 0) {
                now++;
                continue;
            }
            if (ladders > 0) {
                ladders--;
                hasUsedBricks.add(diff);
                now++;
                continue;
            }
            if (bricks > diff) {
                bricks -= diff;
                now++;
                continue;
            }
            while (!hasUsedBricks.isEmpty() && hasUsedBricks.peek() < bricks) {
                bricks -= hasUsedBricks.poll();
                ladders++;
            }
            if (ladders == 0) {
                break;
            }
        }
        return now;
    }
}
