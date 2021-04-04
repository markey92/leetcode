package competition.year2020.day20201122;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201122
 * @ClassName: Leetcode5608
 * @Author: markey
 * @Description:
 * @Date: 2020/11/22 11:14
 * @Version: 1.0
 */
public class Leetcode5608 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[1] - o[0]));
        int res = 0;
        for (int i = 0; i < tasks.length; i++) {
            res += tasks[i][0];
            res = Math.max(res, tasks[i][1]);
        }
        return res;
    }
}
