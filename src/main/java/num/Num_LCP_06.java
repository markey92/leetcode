package num;

/**
 * @ProjectName: leetcode
 * @Package: num
 * @ClassName: Num_LCP_06
 * @Author: markey
 * @Description:
 * @Date: 2020/5/19 23:10
 * @Version: 1.0
 */
public class Num_LCP_06 {
    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count += coin / 2;
            count += coin % 2;
        }
        return count;
    }
}
