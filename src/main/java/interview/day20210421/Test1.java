package interview.day20210421;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20210421
 * @ClassName: Test1
 * @Author: markey
 * @Description:
 * @Date: 2021/4/21 19:01
 * @Version: 1.0
 */
public class Test1 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] direction = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        // 连通图distrij
        Set<Integer> hadReach = new HashSet<>();
        List<Integer> canReach = new ArrayList<>();
        if (grid[0][0] == 0) {
            canReach.add(0);
        }

        int res = 0;
        while (!canReach.isEmpty()) {
            int size = canReach.size();
            res++;
            for (int i = 0; i < size; i++) {
                int node = canReach.remove(0);
                if (hadReach.contains(node)) {
                    continue;
                }
                hadReach.add(node);
                int x = node / m;
                int y = node % m;
                for (int j = 0; j < direction.length; j++) {
                    int nextX = x + direction[j][0];
                    int nextY = y + direction[j][1];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && grid[nextX][nextY] == 0) {
                        canReach.add(nextX * m + nextY);
                    }
                }
                if (node == m * n - 1) return res;
            }
        }
        return -1;
    }
}
