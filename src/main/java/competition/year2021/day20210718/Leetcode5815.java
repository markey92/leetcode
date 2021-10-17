package competition.year2021.day20210718;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210718
 * @ClassName: Leetcode5815
 * @Author: markey
 * @Description:
 * @Date: 2021/7/18 10:42
 * @Version: 1.0
 */
public class Leetcode5815 {
    public long maxPoints(int[][] points) {
        // 考虑目标点在当前点左侧和右侧的场景，并且优化表达式可得
        // 左侧： scores[i][j] = Max(scores[i - 1][k] + k) - j
        // 右侧： scores[i][j] = Max(scores[i - 1][k] - k) + j
        int n = points.length;
        int m = points[0].length;
        long[][] scores = new long[n][m];
        for (int j = 0; j < m; j++) {
            scores[0][j] = points[0][j];
        }
        for (int i = 1; i < n; i++) {
            // 先算左侧最大值
            long max = Long.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, scores[i - 1][j] + j);
                scores[i][j] = points[i][j] + max - j;
            }
            // 再算右侧最大值
            max = Integer.MIN_VALUE;
            for (int j = m - 1; j >= 0; j--) {
                max = Math.max(max, scores[i - 1][j] - j);
                scores[i][j] = Math.max(scores[i][j], points[i][j] + max + j);
            }
        }
        long res = -1;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, scores[n - 1][i]);
        }
        return res;
    }

    // 没有优化的db，复杂度n*m*m
    public long maxPoints1(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        int[][] scores = new int[n][m];
        for (int j = 0; j < m; j++) {
            scores[0][j] = points[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int max = -1;
                for (int k = 0; k < m; k++) {
                    max = Math.max(scores[i - 1][k] - Math.abs(k - j), max);
                }
                scores[i][j] = max + points[i][j];
            }
        }
        int res = -1;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, scores[n - 1][i]);
        }
        return res;
    }
}
