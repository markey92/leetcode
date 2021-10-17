package competition.year2021.day20210620;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210620
 * @ClassName: Leetcode5791
 * @Author: markey
 * @Description:
 * @Date: 2021/6/20 10:46
 * @Version: 1.0
 */
public class Leetcode5791 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] reach = new boolean[grid2.length][grid2[0].length];
        int res = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 0 || reach[i][j]) {
                    continue;
                }
                if (check(grid1, grid2, i, j, reach)) {
                    System.out.println(i + ":" + j);
                    res++;
                }
            }
        }
        return res;
    }
    private boolean check(int[][] grid1, int[][] grid2, int x, int y, boolean[][] reach) {
        if (x <0 || y <0 || x >= grid2.length || y >= grid2[x].length || reach[x][y] || grid2[x][y] == 0) {
            return true;
        }
        boolean res = grid1[x][y] == 1;
        reach[x][y] = true;
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < direction.length; i++) {
            res &= check(grid1, grid2, x + direction[i][0], y + direction[i][1], reach);
        }
        return res;
    }
}
