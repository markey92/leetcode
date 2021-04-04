package competition.year2020.day20200725;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200725
 * @ClassName: Num5456
 * @Author: markey
 * @Description:
 * @Date: 2020/7/25 22:30
 * @Version: 1.0
 */
public class Leetcode5456 {
    public int countOdds(int low, int high) {
        if ((high - low) % 2 == 1) {
            // 偶数个
            return (high - low + 1) / 2;
        } else {
            if (low % 2 == 1) {
                return (high - low) / 2 + 1;
            } else {
                return (high - low) / 2;
            }
        }

    }
}
