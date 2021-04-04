package competition.year2020.day20200419;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200419
 * @ClassName: Other5391
 * @Author: markey
 * @Description:
 * @Date: 2020/4/19 11:19
 * @Version: 1.0
 */
public class Other5391 {
    public int numOfArrays(int n, int m, int k) {
        // 用于递减的数字
        int a = n - k - 1;
        if (a < 0) {
            return 0;
        }
        // 用于非递减的数字
        int b = k + 1;
        int sumB = 1;
        for (int i = 0; i < b; i++) {
            sumB *= m > 0 ? m : 1;
            m--;
        }
        System.out.println(sumB);
        if (sumB < k) {
            return 0;
        }

        int sumA = 1;
        for (int i = 0; i < a; i++) {
            sumA *= m > 0 ? m : 1;
            m--;
        }

        long count = count(a, sumB);
        return (int) (count % 1000000007);
    }

    private long count(int x, int y) {
        if (x <= 1) {
            return y;
        }
        if (y <= 1) {
            return x;
        }
        return x + y + count(x - 1, y) % 1000000007 + count(x, y - 1) % 1000000007;
    }
}
