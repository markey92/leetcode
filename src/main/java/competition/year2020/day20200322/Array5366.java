package competition.year2020.day20200322;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200322
 * @ClassName: Array5366
 * @Author: markey
 * @Description:
 * @Date: 2020/3/22 10:44
 * @Version: 1.0
 */
public class Array5366 {
    public boolean hasValidPath(int[][] grid) {
        return hasValidPath(grid, 0, 0);
    }

    private boolean hasValidPath(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length) {
            return false;
        }
        if (x == grid.length - 1 && y == grid[x].length - 1) {
            return true;
        }
        switch (grid[x][y]) {
            case 1:
                grid[x][y] = 0;
                if (y - 1 >= 0 && (grid[x][y-1] == 4 || grid[x][y-1] == 6 || grid[x][y-1] == 1)) {
                    return hasValidPath(grid, x, y-1);
                }
                if (y + 1 < grid[x].length && (grid[x][y+1] == 3 || grid[x][y+1] == 5 || grid[x][y+1] == 1)) {
                    return hasValidPath(grid, x, y+1);
                }
                System.out.println(1);
                return false;
            case 3:
                grid[x][y] = 0;
                if (y - 1 >= 0 && (grid[x][y-1] == 4 || grid[x][y-1] == 6 || grid[x][y-1] == 1)) {
                    return hasValidPath(grid, x, y-1);
                }
                if (x + 1 < grid.length && (grid[x+1][y] == 2 || grid[x+1][y] == 6 || grid[x+1][y] == 5)) {
                    return hasValidPath(grid, x+1, y);
                }
                System.out.println(3);
                return false;
            case 5:
                grid[x][y] = 0;
                System.out.println(Arrays.toString(grid[0]));
                System.out.println(Arrays.toString(grid[1]));
                if (y - 1 >= 0 && (grid[x][y-1] == 4 || grid[x][y-1] == 6 || grid[x][y-1] == 1)) {
                    return hasValidPath(grid, x, y-1);
                }
                if (x - 1 >= 0 && (grid[x-1][y] == 2 || grid[x-1][y] == 3 || grid[x-1][y] == 4)) {
                    return hasValidPath(grid, x-1, y);
                }
                System.out.println(5);
                return false;
            case 2:
                grid[x][y] = 0;
                if (x - 1 >= 0 && (grid[x-1][y] == 2 || grid[x-1][y] == 3 || grid[x-1][y] == 4)) {
                    return hasValidPath(grid, x-1, y);
                }
                if (x + 1 < grid.length && (grid[x+1][y] == 2 || grid[x+1][y] == 6 || grid[x+1][y] == 5)) {
                    return hasValidPath(grid, x+1, y);
                }
                System.out.println(2);
                return false;
            case 4:
                grid[x][y] = 0;
                if (x + 1 < grid.length && (grid[x+1][y] == 2 || grid[x+1][y] == 6 || grid[x+1][y] == 5)) {
                    return hasValidPath(grid, x+1, y);
                }
                if (y + 1 < grid[x].length && (grid[x][y+1] == 3 || grid[x][y+1] == 5 || grid[x][y+1] == 1)) {
                    return hasValidPath(grid, x, y+1);
                }
                System.out.println(4);
                return false;
            case 6:
                grid[x][y] = 0;
                if (x - 1 >= 0 && (grid[x-1][y] == 2 || grid[x-1][y] == 3 || grid[x-1][y] == 4)) {
                    return hasValidPath(grid, x-1, y);
                }
                if (y + 1 < grid[x].length && (grid[x][y+1] == 3 || grid[x][y+1] == 5 || grid[x][y+1] == 1)) {
                    return hasValidPath(grid, x, y+1);
                }
                System.out.println(6);
                return false;
        }
        return false;
    }
}
