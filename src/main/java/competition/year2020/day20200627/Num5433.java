package competition.year2020.day20200627;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200627
 * @ClassName: Num5433
 * @Author: markey
 * @Description:
 * @Date: 2020/6/27 22:36
 * @Version: 1.0
 */
public class Num5433 {
    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count == k) {
                return i;
            }
        }
        return -1;
    }
}
