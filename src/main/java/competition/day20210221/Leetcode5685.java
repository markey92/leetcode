package competition.day20210221;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210221
 * @ClassName: Leetcode5685
 * @Author: markey
 * @Description:
 * @Date: 2021/2/21 18:46
 * @Version: 1.0
 */
public class Leetcode5685 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        while (index1 < word1.length() && index2 < word2.length()) {
            if (index1 > index2) {
                sb.append(word2.charAt(index2));
                index2++;
            } else {
                sb.append(word1.charAt(index1));
                index1++;
            }
        }
        if (index1 < word1.length()) {
            sb.append(word1.substring(index1));
        }
        if (index2 < word2.length()) {
            sb.append(word2.substring(index2));
        }
        return sb.toString();
    }
}
