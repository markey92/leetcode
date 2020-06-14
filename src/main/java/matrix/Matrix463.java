package matrix;

/**
 * @ProjectName: leetcode
 * @Package: matrix
 * @ClassName: Matrix463
 * @Author: markey
 * @Description:
 * @Date: 2020/6/2 21:51
 * @Version: 1.0
 */
public class Matrix463 {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    if (j - 1 >= 0) {
                        count -= grid[i][j - 1];
                    }
                    if (j + 1 < grid[i].length) {
                        count -= grid[i][j + 1];
                    }
                    if (i - 1 >= 0) {
                        count -= grid[i - 1][j];
                    }
                    if (i + 1 < grid.length) {
                        count -= grid[i + 1][j];
                    }
                }
            }
        }
        return count;
    }
}
