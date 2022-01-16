package competition.year2021.day20211219;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211219
 * @ClassName: Leetcode5956
 * @Author: markey
 * @Description:
 * @Date: 2021/12/19 10:30
 * @Version: 1.0
 */
public class Leetcode5956 {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (is(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean is(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
