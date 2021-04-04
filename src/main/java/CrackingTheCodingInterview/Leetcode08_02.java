package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode08_02
 * @Author: markey
 * @Description:
 * @Date: 2020/9/26 23:17
 * @Version: 1.0
 */
public class Leetcode08_02 {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        List<List<Integer>>[][] dp = new List[n][m];

        // 初始化
        List<Integer> firstPoint = new ArrayList<>();
        firstPoint.add(0);
        firstPoint.add(0);
        dp[0][0] = obstacleGrid[0][0] == 0 ? Collections.singletonList(firstPoint) : null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i > 0) {
                    if (dp[i - 1][j] != null) {
                        List<Integer> thisPoint = new ArrayList<>();
                        thisPoint.add(i);
                        thisPoint.add(j);
                        dp[i][j] = new ArrayList<>(dp[i - 1][j]);
                        dp[i][j].add(thisPoint);
                    }
                }
                // dp[i][j] == null是因为只需要求其中一条路径，可以从上往下过来，就不需要走从左往右过来这条路了
                if (j > 0 && dp[i][j] == null) {
                    if (dp[i][j - 1] != null) {
                        List<Integer> thisPoint = new ArrayList<>();
                        thisPoint.add(i);
                        thisPoint.add(j);
                        dp[i][j] = new ArrayList<>(dp[i][j - 1]);
                        dp[i][j].add(thisPoint);
                    }
                }
            }
        }

        if (dp[n - 1][m - 1] != null) {
            return dp[n - 1][m - 1];
        } else {
            return Collections.emptyList();
        }
    }
}
