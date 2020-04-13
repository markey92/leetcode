package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: queue
 * @ClassName: Queue200
 * @Author: markey
 * @Description:200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 * 通过次数73,857提交次数154,209
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/5 15:36
 * @Version: 1.0
 */
public class Queue200 {
    // BFS 或者 DFS，找出 值为1的节点周围所有节点，这些节点连成一个岛屿。全部置为1，不参与下次扫描
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, new int[] {i, j});
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int[] node) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            int x = node[0], y = node[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == '1') {
                grid[x][y] = '0';
                if (x - 1 >= 0) {
                    queue.add(new int[]{x - 1, y});
                }
                if (x + 1 < grid.length) {
                    queue.add(new int[]{x + 1, y});
                }
                if (y - 1 >= 0) {
                    queue.add(new int[]{x, y - 1});
                }
                if (y + 1 < grid[x].length) {
                    queue.add(new int[]{x, y + 1});
                }
            }
        }
        System.out.println("………………………………");
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}
