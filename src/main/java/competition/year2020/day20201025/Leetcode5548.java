package competition.year2020.day20201025;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201025
 * @ClassName: Leetcode5548
 * @Author: markey
 * @Description:
 * @Date: 2020/10/25 10:41
 * @Version: 1.0
 */
public class Leetcode5548 {
    public int minimumEffortPath(int[][] heights) {
        return dfs(heights, new ArrayList<>(), 0, 0, 0, 0);
    }
    int[][] direction = new int[][] {{1,0}, {-1, 0}, {0, -1}, {0, 1}};
    private int dfs(int[][] heights, List<int[]> hasReach, int x, int y, int parentX, int parentY) {
        hasReach.add(new int[] {x, y});
        log(hasReach);
        int res = Math.abs(heights[x][y] - heights[parentX][parentY]);
        if (x == heights.length - 1&& y == heights[x].length - 1) {
            hasReach.remove(hasReach.size() - 1);
            // 到达目的地
            return res;
        }
        System.out.println(res);

        // 遍历 可以到达的四个点
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < direction.length; i++) {
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];
            // 找出其中到达目的地的最小值
            if (nextX >= 0 && nextX < heights.length && nextY >=0 && nextY < heights[nextX].length && !hasReach(hasReach, nextX, nextY)) {
                min = Math.min(min, dfs(heights, hasReach, nextX, nextY, x, y));
            }
        }
        hasReach.remove(hasReach.size() - 1);
        return Math.max(res, min);
    }

    private boolean hasReach(List<int[]> hasReach, int x, int y) {
        for (int i = 0; i < hasReach.size(); i++) {
            if (hasReach.get(i)[0] == x && hasReach.get(i)[1] == y) {
                return true;
            }
        }
        return false;
    }
    private void log(List<int[]> hasReach) {
        for (int i = 0; i < hasReach.size(); i++) {
            System.out.print("->" + hasReach.get(i)[0] + ":" + hasReach.get(i)[1] + " ");
        }
        System.out.println();
    }
}
