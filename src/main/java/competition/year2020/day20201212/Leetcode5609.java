package competition.year2020.day20201212;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201212
 * @ClassName: Leetcode5609
 * @Author: markey
 * @Description:
 * @Date: 2020/12/12 22:30
 * @Version: 1.0
 */
public class Leetcode5609 {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        for (String word : words) {
            res++;
            for (int i = 0; i < word.length(); i++) {
                if (allowed.indexOf(word.charAt(i)) < 0) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}
