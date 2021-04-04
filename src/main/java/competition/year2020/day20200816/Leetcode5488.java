package competition.year2020.day20200816;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200816
 * @ClassName: Leetcode5488
 * @Author: markey
 * @Description:
 * @Date: 2020/8/16 10:34
 * @Version: 1.0
 */
public class Leetcode5488 {
    public int minOperations(int n) {
        if (n == 1) {
            return 0;
        }
        return n / 2 == 1 ? (n + 1) / (n / 2) / 2 : minOperations(n - 1) + n / 2;
    }
}
