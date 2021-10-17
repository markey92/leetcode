package competition.year2021.day20210704;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210704
 * @ClassName: Leetcode5801
 * @Author: markey
 * @Description:
 * @Date: 2021/7/4 10:33
 * @Version: 1.0
 */
public class Leetcode5801 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = dist[i] / speed[i] + (dist[i] % speed[i] > 0 ? 1 : 0);
        }
        Arrays.sort(time);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (time[i] <= i) {
                break;
            }
            res++;
        }
        return res;
    }
}
