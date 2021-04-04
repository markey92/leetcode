package competition.year2020.day20200719;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200719
 * @ClassName: Leetcode5464
 * @Author: markey
 * @Description:
 * @Date: 2020/7/19 10:30
 * @Version: 1.0
 */
public class Leetcode5464 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = 0;
        int res = numBottles;
        emptyBottles += numBottles;
        while (emptyBottles >= numExchange) {
            int newBottle = emptyBottles / numExchange;
            res += newBottle;
            emptyBottles %= numExchange;
            emptyBottles += newBottle;
        }
        return res;
    }
}
