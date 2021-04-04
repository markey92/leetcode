package competition.day20210306;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210306
 * @ClassName: Leetcode5680
 * @Author: markey
 * @Description:
 * @Date: 2021/3/6 22:30
 * @Version: 1.0
 */
public class Leetcode5680 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1;
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] == x && Math.abs(y - point[1]) < length) {
                length = Math.abs(y - point[1]);
                res = i;
            }
            if (point[1] == y && Math.abs(x - point[0]) < length) {
                length = Math.abs(x - point[0]);
                res = i;
            }
        }
        return res;
    }
}
