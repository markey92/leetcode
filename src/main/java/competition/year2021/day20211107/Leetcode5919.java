package competition.year2021.day20211107;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211107
 * @ClassName: Leetcode5919
 * @Author: markey
 * @Description:
 * @Date: 2021/11/7 10:44
 * @Version: 1.0
 */
public class Leetcode5919 {
    public long countVowels(String word) {
        long res = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isMatch(word.charAt(i))) {
                res += (long) (i + 1) * (word.length() - i);
            }
        }
        return res;
    }

    private boolean isMatch(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
