package competition.year2021.day20210530;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210530
 * @ClassName: Leetcode5773
 * @Author: markey
 * @Description:
 * @Date: 2021/5/30 10:37
 * @Version: 1.0
 */
public class Leetcode5773 {
    public String maxValue(String n, int x) {
        boolean negative = n.charAt(0) == '-';
        for (int i = negative ? 1 : 0; i < n.length(); i++) {
            if (negative) {
                if (n.charAt(i) - '0' >= x) {
                    return n.substring(0, i) + x + n.substring(i);
                }
            } else {
                if (n.charAt(i) - '0' < x) {
                    return n.substring(0, i + 1) + x + n.substring(i + 1);
                }
            }
        }
        return n;
    }
}
