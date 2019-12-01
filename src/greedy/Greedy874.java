package greedy;

public class Greedy874 {
    /**
     * 模拟走路，不复杂，就是繁琐
     * 官方题解有优化方案判断是否碰到障碍点
     * 必须注意使用 集合 Set 作为对障碍物使用的数据结构，以便我们可以有效地检查下一步是否受阻。如果不这样做，我们检查 该点是障碍点吗 可能会慢大约 10000 倍。
     * for (int[] obstacle: obstacles) {
     *             long ox = (long) obstacle[0] + 30000;
     *             long oy = (long) obstacle[1] + 30000;
     *             obstacleSet.add((ox << 16) + oy);
     *         }
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/walking-robot-simulation/solution/mo-ni-xing-zou-ji-qi-ren-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * Runtime: 1258 ms, faster than 5.05% of Java online submissions for Walking Robot Simulation.
     * Memory Usage: 59.7 MB, less than 16.67% of Java online submissions for Walking Robot Simulation.
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        /**
         * 0:向前： y+1；
         * 1：向右： x+1；
         * 2：向后： y-1；
         * 3：向左： x-1；
         */
        int direction = 0;
        int ans = 0;
        for (int command: commands) {
            switch (command) {
                case -2 :
                    direction = (direction + 3) % 4;
                    break;
                case -1 :
                    direction = (direction + 1) % 4;
                    break;
                default: {
                    switch (direction) {
                        case 0 :
                            while (command > 0) {
                                if (!isObstacles(x, y+1, obstacles)) y += 1;
                                command -- ;
                                ans = Math.max(ans, x*x + y*y);
                            }
                            break;
                        case 1 :
                            while (command > 0) {
                                if (!isObstacles(x + 1, y, obstacles)) x += 1;
                                command -- ;
                                ans = Math.max(ans, x*x + y*y);
                            }
                            break;
                        case 2 :
                            while (command > 0) {
                                if (!isObstacles(x, y-1, obstacles))y -= 1;
                                command -- ;
                                ans = Math.max(ans, x*x + y*y);
                            }
                            break;
                        case 3 :
                            while (command > 0) {
                                if (!isObstacles(x-1, y, obstacles))x -=  1;
                                command -- ;
                                ans = Math.max(ans, x*x + y*y);
                            }
                            break;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isObstacles(int x, int y, int[][] obstacles ) {
        for (int[] obstacle: obstacles) {
            if (obstacle[0] == x && obstacle[1] == y) {
                return true;
            }
        }
        return false;
    }
}
