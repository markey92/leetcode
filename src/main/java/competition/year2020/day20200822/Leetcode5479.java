package competition.year2020.day20200822;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200822
 * @ClassName: Leetcode5479
 * @Author: markey
 * @Description:
 * @Date: 2020/8/22 22:30
 * @Version: 1.0
 */
public class Leetcode5479 {
    public String thousandSeparator(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (n > 0) {
            if (count == 3) {
                sb.append(".");
                count = 0;
            }
            sb.append(n % 10);
            n /= 10;
            count++;
        }
        return sb.reverse().toString();
    }
}
