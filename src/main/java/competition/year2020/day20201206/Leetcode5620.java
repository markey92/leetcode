package competition.year2020.day20201206;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201206
 * @ClassName: Leetcode5620
 * @Author: markey
 * @Description:
 * @Date: 2020/12/6 10:38
 * @Version: 1.0
 */
public class Leetcode5620 {
    public int concatenatedBinary(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res = ((res << lowBit(i)) + i) % 1000000007;
            System.out.println(res);
            System.out.println(Long.toBinaryString(118505380540l));
        }
        return (int) (res % 1000000007);
    }

    private int lowBit(int n) {
        int max = 0;
        while (n > 0) {
            n >>= 1;
            max++;
        }
        return max;
    }
}
