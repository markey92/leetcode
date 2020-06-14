package geometric;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: geometric
 * @ClassName: Geometric49
 * @Author: markey
 * @Description:
 * @Date: 2020/5/18 23:35
 * @Version: 1.0
 */
public class Geometric149 {
    public int maxPoints(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<BigDecimal, Integer> slopes = new HashMap<>(); // 记录斜率相同的点的个数，不包括自己
            // 算出其他点到当前点的斜率
            int samePoint = 0; // 相同点，包括他自己
            int max = 0;
            for (int j = 0; j < points.length; j++) {
                if (Arrays.equals(points[i], points[j])) {
                    samePoint++;
                    continue;
                }
                BigDecimal slope = slope(points[i], points[j]);
                slopes.put(slope, slopes.getOrDefault(slope, 0) + 1);
                max = Math.max(max, slopes.get(slope));
            }
            res = Math.max(res, max + samePoint);
            System.out.println(samePoint);
            System.out.println(slopes);
        }

        // 斜率相同，说明在同一直线上
        return res;
    }

    // 算两点间的斜率 有精度问题
    private BigDecimal slope(int[] pointA, int[] pointB) {
        if ((pointA[0] - pointB[0]) == 0) {
            // 使用-1来表示斜率无穷大
            return BigDecimal.valueOf(Double.MAX_EXPONENT);
        }
        if (pointB[1] > pointA[1]) {
            return slope(pointB, pointA);
        }
        return BigDecimal.valueOf(pointA[1] - pointB[1]).divide(BigDecimal.valueOf(pointA[0] - pointB[0]), 2, BigDecimal.ROUND_FLOOR);
    }
}
