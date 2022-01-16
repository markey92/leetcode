package competition.year2021.day20210815;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210815
 * @ClassName: Leetcode5844
 * @Author: markey
 * @Description:
 * @Date: 2021/8/15 10:40
 * @Version: 1.0
 */
public class Leetcode5844 {
    public int minNonZeroProduct(int p) {
        long max = (1 << p) - 1;
        System.out.println(max);
        return (int) (Math.pow(max - 1, (max / 2) % 32) * max % 1_000_000_007);
    }
}
