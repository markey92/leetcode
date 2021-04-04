package competition.year2020.day20200830;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200830
 * @ClassName: Leetcode5501
 * @Author: markey
 * @Description:
 * @Date: 2020/8/30 11:13
 * @Version: 1.0
 */
public class Leetcode5501 {

    public int minDays1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] linkCount = new int[n][m];
        int min = Integer.MAX_VALUE;
        int countOfIsLand = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    countOfIsLand++;
                    min = Math.min(min, count(grid, i, j));
                    // 只剩自己一座岛的情况特殊处理，也不能认为是分离的
                    if (countOfIsLand == min + 1) {
                        min = countOfIsLand;
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    private int count(int[][] grid, int n, int m) {
        int count = 0;
        if (n - 1 >= 0) {
            count += grid[n - 1][m];
        }
        if (n + 1 < grid.length) {
            count += grid[n + 1][m];
        }
        if (m - 1 >= 0) {
            count += grid[n][m - 1];
        }
        if (m + 1 < grid[n].length) {
            count += grid[n][m + 1];
        }
        return count;
    }
}
