package value;

/**
 * @ProjectName: leetcode
 * @Package: value
 * @ClassName: Leetcode1109
 * @Author: markey
 * @Description:
 * https://blog.csdn.net/qq_21201267/article/details/106423509
 * @Date: 2020/9/20 12:01
 * @Version: 1.0
 */
public class Leetcode1109 {
    /**
     * 等差数列-》差分思想
     * 看数据量这么大，暴力肯定要超时
     * 左端点+num，右端点后面-num，中间的状态不变，就省了给每个位置更新的时间
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] bookTemp = new int[n + 1];
        for (int i = 0; i < bookings.length; i++) {
            int start = bookings[i][0] - 1;
            int end = bookings[i][1] - 1;
            int num = bookings[i][2];
            bookTemp[start] += num;
            bookTemp[end + 1] -= num;
        }
        int[] res = new int[n];
        res[0] = bookTemp[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + bookTemp[i];
        }
        return res;
    }
}
