package competition.year2020.day20200802;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200802
 * @ClassName: Leetcode5477
 * @Author: markey
 * @Description:
 * @Date: 2020/8/2 10:49
 * @Version: 1.0
 */
public class Leetcode5477 {
    public int minSwaps(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        int count = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = i; j < n; j++) {
//                if (grid[j][i] == 1) {
//                    count += swap(grid, i, j);
//                }
//            }
//        }
//        return count;
        int n = grid.length;
        List<List<Integer>> maybe = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    temp.add(j);
                }
            }
            if (temp.size() == 0) {
                // 某列没有1，无法转化
                return -1;
            }
            maybe.add(temp);
        }
        return 0;

    }

    private int swap(int[][] grid, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }
        int[] temp = grid[j];
        for (int k = i + 1; k <= j; k++) {
            grid[k] = grid[k - 1];
        }
        grid[i] = temp;
        return j - i;
    }
}
