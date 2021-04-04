package competition.day20210314;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210314
 * @ClassName: Leetcode5701
 * @Author: markey
 * @Description:
 * @Date: 2021/3/14 10:30
 * @Version: 1.0
 */
public class Leetcode5701 {
    public boolean areAlmostEqual(String s1, String s2) {
        char diff1 = ' ', diff2 = ' ';
        int diffCount = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffCount == 0) {
                    diff1 = s1.charAt(i);
                    diff2 = s2.charAt(i);
                } else if (diffCount == 1){
                    if ((s1.charAt(i) != diff2 ||s2.charAt(i) != diff1)) {
                        return false;
                    }
                } else {
                    return false;
                }
                diffCount++;
            }
        }
        return (diffCount == 0 || diffCount == 2) ?true : false;
    }
}
