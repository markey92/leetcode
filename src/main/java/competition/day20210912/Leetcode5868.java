package competition.day20210912;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210912
 * @ClassName: Leetcode5868
 * @Author: markey
 * @Description:
 * @Date: 2021/9/12 10:33
 * @Version: 1.0
 */
public class Leetcode5868 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> count = new HashMap<>();
        for (int[] rectangle : rectangles) {
            double x = ((double) rectangle[0] / rectangle[1]);
            count.put(x, count.getOrDefault(x, 0L) + 1);
        }
        long res = 0;
        for (long y : count.values()) {
            res += y * (y - 1) / 2;
        }
        return res;
    }
}
