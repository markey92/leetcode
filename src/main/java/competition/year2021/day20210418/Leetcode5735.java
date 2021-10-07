package competition.year2021.day20210418;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210418
 * @ClassName: Leetcode5735
 * @Author: markey
 * @Description:
 * @Date: 2021/4/18 10:32
 * @Version: 1.0
 */
public class Leetcode5735 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                coins -= costs[i];
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
