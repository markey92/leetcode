package competition.year2020.day20200906;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200906
 * @ClassName: Leetcode5509
 * @Author: markey
 * @Description:
 * @Date: 2020/9/6 10:54
 * @Version: 1.0
 */
public class Leetcode5509 {
    public int minCost(String s, int[] cost) {
        int max = Integer.MIN_VALUE;
        char temp = '0';
        int allCost = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == temp) {
                max = Math.max(max, cost[i]);
                allCost += cost[i];
            } else {
                if (max != Integer.MIN_VALUE) {
                    System.out.println(max);
                    res += allCost - max;
                }
                allCost = cost[i];
                temp = s.charAt(i);
                max = cost[i];
            }
        }
        if (max != Integer.MIN_VALUE) {
            res += allCost - max;
        }
        return res;
    }
}
