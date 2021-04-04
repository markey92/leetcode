package competition.year2020.day20201212;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201212
 * @ClassName: Leetcode5611
 * @Author: markey
 * @Description:
 * @Date: 2020/12/12 22:45
 * @Version: 1.0
 */
public class Leetcode5611 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[] value = new int[n];
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            index.add(i);
            value[i] = aliceValues[i] + bobValues[i];
        }
        index.sort((o1, o2) -> value[o2] - value[o1]);
        int X = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                X += aliceValues[index.get(i)];
            } else {
                X -= bobValues[index.get(i)];
            }
        }
        if (X == 0) {
            return 0;
        } else if (X > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
