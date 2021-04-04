package competition.year2020.day20200809;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200809
 * @ClassName: Leetcode5484
 * @Author: markey
 * @Description:
 * @Date: 2020/8/9 10:40
 * @Version: 1.0
 */
public class Leetcode5484 {
    public char findKthBit(int n, int k) {
        System.out.println(n + " " + k);
        int count = count(n);
        if (n == 1) {
            return '0';
        }
        System.out.println(count / 2 + 1);
        if (count / 2 + 1 == k) {
            return '1';
        } else if (k > (count / 2 + 1)) {
            return findKthBit(n - 1, count - k) == '0' ? '1' : '0';
        } else {
            return findKthBit(n - 1, k);
        }

    }
    private int count(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = res * 2 + 1;
        }
        return res;
    }
}
