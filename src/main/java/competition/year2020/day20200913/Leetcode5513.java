package competition.year2020.day20200913;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200913
 * @ClassName: Leetcode5513
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 10:49
 * @Version: 1.0
 */
public class Leetcode5513 {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> pointList = new ArrayList<>();
        for (int i = 1; i < points.length; i++) {
            pointList.add(points[i]);
        }
        int res = 0;
        List<int[]> hasReach = new ArrayList<>();
        hasReach.add(points[0]);
        while (hasReach.size() < points.length) {
            int[] temp = pointList.get(0);
            int cost = Integer.MAX_VALUE;
            for (int i = 0; i < hasReach.size(); i++) {
                int[] now = hasReach.get(i);
                for (int j = 0; j < pointList.size(); j++) {
                    int costTemp = cost(pointList.get(j), now);
                    if (costTemp < cost) {
                        temp = pointList.get(j);
                        cost = costTemp;
                    }
                }
            }
            pointList.remove(temp);
            hasReach.add(temp);
            res += cost;
        }
        return res;
    }
    private int cost(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
