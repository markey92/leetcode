package competition.year2021.day20210808;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210808
 * @ClassName: Leetcode5841
 * @Author: markey
 * @Description:
 * @Date: 2021/8/8 11:25
 * @Version: 1.0
 */
public class Leetcode5841 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] res = new int[n];
        res[0] = 1;
        dfs(obstacles, res, n - 1);
        return res;
    }

    public int dfs(int[] obstacles, int[] res, int n) {
        if (res[n] != 0) {
            return res[n];
        }
        int x = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = dfs(obstacles, res, i);
            if (obstacles[i] <= obstacles[n]) {
                x = Math.max(x, res[i] + 1);
            }
        }
        res[n] = x;
        return x;
    }
}
