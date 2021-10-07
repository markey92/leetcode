package competition.year2021.day20210207;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210207
 * @ClassName: Leetcode5673
 * @Author: markey
 * @Description:
 * @Date: 2021/2/7 21:17
 * @Version: 1.0
 */
public class Leetcode5673 {
    public int maximumScore(int a, int b, int c) {
        // 使a最大
        if (a < c) {
            c = a + c;
            a = c - a;
            c = c - a;
        }
        if (a < b) {
            b = a + b;
            a = b - a;
            b = b - a;
        }
        // a大于b和c之和
        if (a > b + c) {
            return a;
        }
        // a小于b和c之和
        return a + (b + c - a) / 2;
    }
}
