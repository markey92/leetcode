package competition.year2021.day20210718;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210718
 * @ClassName: Leetcode5161
 * @Author: markey
 * @Description:
 * @Date: 2021/7/18 10:30
 * @Version: 1.0
 */
public class Leetcode5161 {
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        for (String s : text.split(" ")) {
            boolean con = false;
            for (char c : s.toCharArray()) {
                if (brokenLetters.indexOf(c) > -1) {
                    con = true;
                    break;
                }
            }
            if (!con) {
                res++;
            }
        }
        return res;
    }
}
