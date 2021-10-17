package competition.day20210808;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210808
 * @ClassName: Leetcode5838
 * @Author: markey
 * @Description:
 * @Date: 2021/8/8 10:30
 * @Version: 1.0
 */
public class Leetcode5838 {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[i]);
            if (s.length() > stringBuilder.length()) {
                continue;
            } else if (s.length() < stringBuilder.length()) {
                return false;
            } else {
                return s.equals(stringBuilder.toString());
            }
        }
        return false;
    }
}
