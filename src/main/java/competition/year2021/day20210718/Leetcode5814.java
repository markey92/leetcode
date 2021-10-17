package competition.year2021.day20210718;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210718
 * @ClassName: Leetcode5814
 * @Author: markey
 * @Description:
 * @Date: 2021/7/18 10:36
 * @Version: 1.0
 */
public class Leetcode5814 {
    public int addRungs(int[] rungs, int dist) {
        int res = 0;
        int start = 0;
        for (int i = 0; i < rungs.length;) {
            if (rungs[i] - start <= dist) {
                start = rungs[i];
                i++;
            } else {
                res += (rungs[i] - start - 1) / dist;
                start += dist * res;
            }
        }
        return res;
    }
}
