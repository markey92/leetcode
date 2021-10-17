package competition.year2021.day20210626;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210626
 * @ClassName: Leetcode5781
 * @Author: markey
 * @Description:
 * @Date: 2021/6/26 22:37
 * @Version: 1.0
 */
public class Leetcode5781 {
    public String removeOccurrences(String s, String part) {
        int start = 0;
        StringBuilder sb = new StringBuilder(s);
        while (start <= sb.length() - part.length()) {
            if (sb.subSequence(start, start + part.length()).equals(part)) {
                sb.delete(start, start + part.length());
                start = 0;
            } else {
                start++;
            }
        }
        return sb.toString();
    }
}
