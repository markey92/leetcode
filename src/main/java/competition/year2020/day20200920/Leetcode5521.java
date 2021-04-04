package competition.year2020.day20200920;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200920
 * @ClassName: Leetcode5521
 * @Author: markey
 * @Description:
 * @Date: 2020/9/20 11:10
 * @Version: 1.0
 */
public class Leetcode5521 {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        List<Long>[][] dp = new List[n][m];

        dp[0][0] = new ArrayList<>();
        dp[0][0].add((long) grid[0][0]);

        for (int i = 1; i < n; i++) {
            dp[i][0] = new ArrayList<>();
            dp[i][0].add(dp[i - 1][0].get(0) * grid[i][0]);
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = new ArrayList<>();
            dp[0][i].add(dp[0][i - 1].get(0) * grid[0][i]);
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                List<Long> now = new ArrayList<>();
                List<Long> top = dp[i - 1][j];
                List<Long> left = dp[i][j - 1];
//                System.out.println("I:"+i + " j:" + (j-1) +left);
                for (int k = 0; k < top.size(); k++) {
                    now.add(top.get(k) * grid[i][j]);
                }
                for (int k = 0; k < left.size(); k++) {
                    now.add(left.get(k) * grid[i][j]);
                }
                dp[i][j] = now.stream().distinct().collect(Collectors.toList());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j].stream().max(Long::compareTo).get() + " ");
            }
            System.out.println();
        }

        long res = -1;
        List<Long> temp = dp[n - 1][m - 1];
        for (int i = 0; i < temp.size(); i++) {
            res = Math.max(temp.get(i), res);
        }
        return (int) res % 1000000007;
    }
}
