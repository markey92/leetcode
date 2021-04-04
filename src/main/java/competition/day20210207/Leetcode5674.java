package competition.day20210207;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210207
 * @ClassName: Leetcode5674
 * @Author: markey
 * @Description:
 * @Date: 2021/2/7 21:40
 * @Version: 1.0
 */
public class Leetcode5674 {
    public String largestMerge(String word1, String word2) {
        int index1 = 0, index2 = 0;
        StringBuilder sb = new StringBuilder();
        while (index1 < word1.length() || index2 < word2.length()) {
            if (index1 >= word1.length()) {
                sb.append(word2.charAt(index2));
                index2++;
            } else if (index2 >= word2.length()) {
                sb.append(word1.charAt(index1));
                index1++;
            } else if (word1.charAt(index1) > word2.charAt(index2)) {
                sb.append(word1.charAt(index1));
                index1++;
            } else if (word2.charAt(index2) > word1.charAt(index1)) {
                sb.append(word2.charAt(index2));
                index2++;
            } else {
                if (word1.substring(index1, word1.length()).compareTo(word2.substring(index2, word2.length())) > 0) {
                    sb.append(word1.charAt(index1));
                    index1++;
                } else {
                    sb.append(word2.charAt(index2));
                    index2++;
                }
            }
        }
        return sb.toString();
    }
}
