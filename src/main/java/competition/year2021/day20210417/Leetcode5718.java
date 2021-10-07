package competition.year2021.day20210417;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210417
 * @ClassName: Leetcode5718
 * @Author: markey
 * @Description:
 * @Date: 2021/4/17 22:35
 * @Version: 1.0
 */
public class Leetcode5718 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < points.length; j++) {
                if (Math.pow(points[j][0] - queries[i][0], 2) + Math.pow(points[j][1] - queries[i][1], 2) <= Math.pow(queries[i][2], 2)) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
