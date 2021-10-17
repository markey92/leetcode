package competition.year2021.day20210627;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210627
 * @ClassName: Leetcode5798
 * @Author: markey
 * @Description:
 * @Date: 2021/6/27 10:33
 * @Version: 1.0
 */
public class Leetcode5798 {
    public int[][] rotateGrid(int[][] grid, int k) {
        int rotate = Math.min(grid.length / 2, grid[0].length / 2);
        for (int i = 0; i < rotate; i++) {
            rotate(grid, i, i, grid.length - 1 - i, grid[0].length - 1 - i, k);
        }
        return grid;
    }

    private void rotate(int[][] grid, int starti, int startj, int endi, int endj, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = startj; i < endj; i++) {
            res.add(grid[starti][i]);
        }
        for (int i = starti; i < endi; i++) {
            res.add(grid[i][endj]);
        }
        for (int i = endj; i > starti ; i--) {
            res.add(grid[endi][i]);
        }
        for (int i = endi; i > starti; i--) {
            res.add(grid[i][startj]);
        }
        k = k % res.size();
        List<Integer> newRes = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            newRes.add(res.get((i + k) % res.size()));
        }
        System.out.println(newRes);
        int j = 0;
        for (int i = startj; i < endj; i++) {
            grid[starti][i] = newRes.get(j);
            j++;
        }
        for (int i = starti; i < endi; i++) {
            grid[i][endj] = newRes.get(j);
            j++;
        }
        for (int i = endj; i > starti ; i--) {
            grid[endi][i] = newRes.get(j);
            j++;
        }
        for (int i = endi; i > starti; i--) {
            grid[i][startj] = newRes.get(j);
            j++;
        }
    }
}
