package competition.day20210815;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210815
 * @ClassName: Leetcode5843
 * @Author: markey
 * @Description:
 * @Date: 2021/8/15 10:30
 * @Version: 1.0
 */
public class Leetcode5843 {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.indexOf(pattern) > -1) {
                count++;
            }
        }
        return count;
    }
}
