package competition.year2021.day20210405;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210405
 * @ClassName: Test2
 * @Author: markey
 * @Description:
 * @Date: 2021/4/5 15:44
 * @Version: 1.0
 */
public class Test2 {
    public int orchestraLayout(int num, int xPos, int yPos) {
        int[][] direction = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] grid = new int[num][num];
        int count = 0;
        int res = 0;
        int x = 0;
        int y = -1;
        int minX = 0;
        int maxX = num - 1;
        int minY = 0;
        int maxY = num - 1;
        for (int i = 0; i < num * num; i++) {
            x = x + direction[count][0];
            y = y + direction[count][1];
            res = (res % 9) + 1;
            if (y == yPos && x == xPos) {
                return res;
            }
            grid[x][y] = 1;
            int nextX = x + direction[count][0];
            int nextY = y + direction[count][1];
            if (nextX == -1 || nextX == num || nextY == -1 || nextY == num || grid[nextX][nextY] == 1) {
                count = (count + 1) % 4;
                if (nextX == -1
                ) {

                }
            }
        }
        return -1;
     }
}
