package competition.year2021.day20211114;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211114
 * @ClassName: Leetcode5926
 * @Author: markey
 * @Description:
 * @Date: 2021/11/14 10:31
 * @Version: 1.0
 */
public class Leetcode5926 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = 0;
        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    n++;
                }
                if (tickets[k] == 0) {
                    return n;
                }
            }
        }
        return n;
    }
}
