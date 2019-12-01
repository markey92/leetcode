package dynamicProgramming;

public class Dp121 {
    /**
     * Runtime: 1 ms, faster than 86.20% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return max;
    }
}
