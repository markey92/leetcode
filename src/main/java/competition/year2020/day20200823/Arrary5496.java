package competition.year2020.day20200823;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200823
 * @ClassName: Arrary5496
 * @Author: markey
 * @Description:
 * @Date: 2020/8/23 10:52
 * @Version: 1.0
 */
public class Arrary5496 {
    public int maxCoins(int[] piles) {
        int n = piles.length / 3;
        Arrays.sort(piles);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += piles[n + i * 2];
        }
        return sum;
    }
}
