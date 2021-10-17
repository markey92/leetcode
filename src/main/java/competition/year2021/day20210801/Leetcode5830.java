package competition.year2021.day20210801;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210801
 * @ClassName: Leetcode5830
 * @Author: markey
 * @Description:
 * @Date: 2021/8/1 10:35
 * @Version: 1.0
 */
public class Leetcode5830 {
    public boolean isThree(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count > 3) {
                return false;
            }
        }
        return count == 3;
    }
}
