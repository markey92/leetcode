package competition.year2020.day20201122;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201122
 * @ClassName: Leetcode5606
 * @Author: markey
 * @Description:
 * @Date: 2020/11/22 10:33
 * @Version: 1.0
 */
public class Leetcode5606 {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (k - n > 0) {
            if (k - n >= 26) {
                sb.append('z');
                k -= 26;
            } else {
                sb.append((char)('a' + k - n));
                k = n - 1;
            }
            n--;
        }
        while (n > 0) {
            sb.append('a');
            n--;
        }
        return sb.reverse().toString();
    }
}
