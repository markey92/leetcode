package competition.year2020.day20201017;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201017
 * @ClassName: Leetcode5527
 * @Author: markey
 * @Description:
 * @Date: 2020/10/17 23:43
 * @Version: 1.0
 */
public class Leetcode5527 {
    public int numberOfSets(int n, int k) {
        System.out.println(num(n - 1, k));
        return (int) (num(n - 1, k) );
    }
    public long num(int n, int k) {
        if (k == 0 || n == 1 || n < k) {
            return 0;
        }
        if (k == 1) {
            return (n + 1) * n / 2;
        }
        if (n == k) {
            return 1;
        }
        return (num(n - 1, k - 1)  +  num(n - 1, k) * 2 );
    }
}
