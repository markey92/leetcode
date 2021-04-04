package competition.year2020.day20200516;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200516
 * @ClassName: String5396
 * @Author: markey
 * @Description:
 * @Date: 2020/5/16 22:31
 * @Version: 1.0
 */
public class String5396 {
    public int maxPower(String s) {
        int max = 0;
        int count = 0;
        char preChar = s.charAt(0);
        for (char c: s.toCharArray()) {
            if (c == preChar) {
                count++;
            } else {
                preChar = c;
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
