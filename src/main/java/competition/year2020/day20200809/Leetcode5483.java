package competition.year2020.day20200809;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200809
 * @ClassName: Leetcode5483
 * @Author: markey
 * @Description:
 * @Date: 2020/8/9 10:30
 * @Version: 1.0
 */
public class Leetcode5483 {
    public String makeGood(String s) {
        int index = 0;
        StringBuilder sb = new StringBuilder(s);
        while (index + 1 < sb.length()) {
            System.out.println(sb.charAt(index) + 1);
            System.out.println(sb.charAt(index + 1) + 1);
            System.out.println(sb.charAt(index) == (sb.charAt(index + 1) + 26));
            if (sb.charAt(index) - 'a' == (sb.charAt(index + 1) - 'A') || sb.charAt(index) - 'A' == (sb.charAt(index + 1) - 'a')) {
                sb.deleteCharAt(index + 1);
                sb.deleteCharAt(index);
                index = index == 0 ? 0 : index - 1;
            } else {
                index++;
            }
        }
        return sb.toString();
    }
}
