package competition.year2020.day20201213;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201213
 * @ClassName: Letcode5625
 * @Author: markey
 * @Description:
 * @Date: 2020/12/13 10:32
 * @Version: 1.0
 */
public class Letcode5625 {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            res += n % 2;
            res += n / 2;
            n /= 2;
        }
        return res;
    }
}
