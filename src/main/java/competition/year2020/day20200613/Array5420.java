package competition.year2020.day20200613;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200613
 * @ClassName: Array5420
 * @Author: markey
 * @Description:
 * @Date: 2020/6/13 22:31
 * @Version: 1.0
 */
public class Array5420 {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int min = 1;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    min = prices[j];
                    break;
                }
            }
            res[i] = prices[i] / min;
        }
        return res;
    }
}
