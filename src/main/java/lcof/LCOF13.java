package lcof;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF13
 * @Author: markey
 * @Description:面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/1 23:24
 * @Version: 1.0
 */
public class LCOF13 {
    //BFS
    public int movingCount(int m, int n, int k) {
        int [][] map = new int[m][n];

        // 下次可以到达的节点
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        // 节点数
        int count = 1;
        // 节点有没被踩过
        map[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];
            // 往上走
            if (x > 0 && map[x - 1][y] != 1 && sumBit(x-1) + sumBit(y) <= k) {
                queue.add(new int[]{x-1, y});
                map[x-1][y] = 1;
                count++;
            }
            // 往下走
            if (x < m - 1 && map[x + 1][y] != 1 && sumBit(x+1) + sumBit(y) <= k) {
                queue.add(new int[]{x+1, y});
                map[x+1][y] = 1;
                count++;
            }
            // 往左走
            if (y > 0 && map[x][y-1] != 1 && sumBit(x) + sumBit(y-1) <= k) {
                queue.add(new int[]{x, y-1});
                map[x][y-1] = 1;
                count++;
            }
            // 往下走
            if (y < n - 1 && map[x][y+1] != 1 && sumBit(x) + sumBit(y+1) <= k) {
                queue.add(new int[]{x, y+1});
                map[x][y+1] = 1;
                count++;
            }
        }

        return count;
    }

    public int sumBit(int x) {
        if (x == 0) {
            return 0;
        }
        return x % 10 + sumBit(x / 10);
    }
}
