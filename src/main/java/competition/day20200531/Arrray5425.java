package competition.day20200531;

import java.util.Arrays;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200531
 * @ClassName: Arrray5425
 * @Author: markey
 * @Description:
 * @Date: 2020/5/31 10:42
 * @Version: 1.0
 */
public class Arrray5425 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        long maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        Arrays.sort(verticalCuts);
        long maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 1; i < verticalCuts.length; i++) {
            maxW = Math.max(maxW, verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int) ((maxH * maxW) % 1000000007);
    }
}
