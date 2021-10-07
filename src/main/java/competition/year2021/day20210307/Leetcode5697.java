package competition.year2021.day20210307;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210307
 * @ClassName: Leetcode5697
 * @Author: markey
 * @Description:
 * @Date: 2021/3/7 10:35
 * @Version: 1.0
 */
public class Leetcode5697 {
    public boolean checkOnesSegment(String s) {
        boolean firstOne = false;
        boolean firstZero = false;
        for (int i = 0; i < s.length(); i++) {
            if (firstOne && firstZero && s.charAt(i) == '1') {
                return false;
            }
            if (s.charAt(i) == '0') {
                firstZero = true;
            }
            if (s.charAt(i) == '1') {
                firstOne = true;
            }
        }
        return true;
    }
}
