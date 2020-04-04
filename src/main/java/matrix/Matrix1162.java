package matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: matrix
 * @ClassName: Matrix1162
 * @Author: markey
 * @Description:1162. 地图分析
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/29 22:12
 * @Version: 1.0
 */
public class Matrix1162 {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        if (queue.isEmpty() || queue.size() == grid.length * grid[0].length) {
            return -1;
        }
        int max = 1;
        int[] x = new int[]{-1, 0, 1, 0};
        int[] y = new int[]{0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int length = grid[node[0]][node[1]];
            for (int i = 0; i < 4; i++) {
                int nextX = node[0]+x[i];
                int nextY = node[1]+y[i];
                if (nextX < 0 || nextX >= grid.length || nextY <= 0 || nextY >= grid[nextX].length) {
                    continue;
                }
                if (grid[nextX][nextY] != 0 && (length + 1) < grid[nextX][nextY]) {
                    grid[node[0]+x[i]][node[1]+y[i]] = length + 1;
                    queue.add(new int[] {nextX, nextY});
                    max = max < (length + 1) ? (length + 1) : max;
                    for (int j = 0; j < grid.length; j++) {
                        System.out.println(Arrays.toString(grid[j]));
                    }
                    System.out.println();
                }
            }
        }
        return max;
    }
}
