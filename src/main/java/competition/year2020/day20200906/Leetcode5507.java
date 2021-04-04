package competition.year2020.day20200906;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200906
 * @ClassName: Leetcode5507
 * @Author: markey
 * @Description:
 * @Date: 2020/9/6 10:30
 * @Version: 1.0
 */
public class Leetcode5507 {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '?') {
                for (int j = 0; j < 26; j++) {
                    char newChar = (char) ('a' + j);
                    if ((i == 0 || newChar != sb.charAt(i - 1)) && (i == sb.length() - 1 || newChar != sb.charAt(i + 1))) {
                        sb.setCharAt(i, newChar);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
