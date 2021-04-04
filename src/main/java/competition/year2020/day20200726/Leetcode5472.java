package competition.year2020.day20200726;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200726
 * @ClassName: Leetcode5472
 * @Author: markey
 * @Description:
 * @Date: 2020/7/26 10:32
 * @Version: 1.0
 */
public class Leetcode5472 {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < indices.length; i++) {
            sb.setCharAt(indices[i], s.charAt(i));
        }
        return sb.toString();
    }
}
