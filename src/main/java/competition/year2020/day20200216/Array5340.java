package competition.year2020.day20200216;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200216
 * @ClassName: Array5340
 * @Author: markey
 * @Description:
 * @Date: 2020/2/16 10:32
 * @Version: 1.0
 */
public class Array5340 {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count += grid[i].length - j;
                    break;
                }
            }
        }
        return count;
    }
}
