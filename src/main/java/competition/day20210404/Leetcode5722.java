package competition.day20210404;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210404
 * @ClassName: Leetcode5722
 * @Author: markey
 * @Description:
 * @Date: 2021/4/4 10:31
 * @Version: 1.0
 */
public class Leetcode5722 {
    public String truncateSentence(String s, int k) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k && i < array.length; i++) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(array[i]);
        }
        return sb.toString();
    }
}
