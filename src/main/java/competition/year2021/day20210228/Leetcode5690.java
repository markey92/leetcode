package competition.year2021.day20210228;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210228
 * @ClassName: Leetcode5690
 * @Author: markey
 * @Description:
 * @Date: 2021/2/28 10:34
 * @Version: 1.0
 */
public class Leetcode5690 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < toppingCosts.length; j++) {
                int topping = toppingCosts[j];
                if (i == topping || i == topping * 2) {
                    dp[i] = i;
                    break;
                } else if (topping > i) {
                    update(dp, i, topping);
                } else {
                    update(dp, i, dp[i - topping] + topping);
                    update(dp, i, dp[i - topping * 2] + topping * 2);
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < baseCosts.length; i++) {
            int temp = baseCosts[i];
            if (temp < target) {
                temp = baseCosts[i] + dp[target - baseCosts[i]];
            }
            if (Math.abs(target - temp) < Math.abs(target - res)) {
                res = temp;
            }
            if (Math.abs(target - temp) == Math.abs(target - res)) {
                res = Math.min(res, temp);
            }
        }
        return res;
    }

    public void update(int[] dp, int index, int value) {
        int old = dp[index];
        if (Math.abs(value - index) > Math.abs(old - index)) {
            dp[index] = value;
        }
        if (Math.abs(old - index) == Math.abs(old - value) && value < old) {
            dp[index] = value;
        }
    }
}
