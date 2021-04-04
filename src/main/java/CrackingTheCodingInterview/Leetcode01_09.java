package CrackingTheCodingInterview;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode01_09
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 17:58
 * @Version: 1.0
 */
public class Leetcode01_09 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s2 + s2).indexOf(s1) > -1;
    }
}
