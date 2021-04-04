package competition.year2020.day20201031;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201031
 * @ClassName: Leetcode5540
 * @Author: markey
 * @Description:
 * @Date: 2020/10/31 22:46
 * @Version: 1.0
 */
public class Leetcode5540 {
    public int maxWidthOfVerticalArea(int[][] points) {
        List<Integer> xList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            xList.add(points[i][0]);
        }
        xList.sort(Comparator.comparingInt(o -> o));
        int max = 0;
        for (int i = 1; i < xList.size(); i++) {
            max = Math.max(max, xList.get(i) - xList.get(i - 1));
        }
        return max;
    }
}
