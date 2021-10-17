package competition.year2021.day20210620;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210620
 * @ClassName: Leetcode5788
 * @Author: markey
 * @Description:
 * @Date: 2021/6/20 10:30
 * @Version: 1.0
 */
public class Leetcode5788 {
    public String largestOddNumber(String num) {
        StringBuilder stringBuilder = new StringBuilder(num);
        while (stringBuilder.length() > 0 && Integer.valueOf(stringBuilder.charAt(stringBuilder.length() - 1)) % 2 == 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
