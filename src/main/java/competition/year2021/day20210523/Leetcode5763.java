package competition.year2021.day20210523;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210523
 * @ClassName: Leetcode5763
 * @Author: markey
 * @Description:
 * @Date: 2021/5/23 10:30
 * @Version: 1.0
 */
public class Leetcode5763 {
    public boolean checkZeroOnes(String s) {
        int maxZero = 0;
        int maxOne = 0;
        int zero = 0;
        int one = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                one = 0;
                zero++;
                maxZero = Math.max(maxZero, zero);
            } else {
                one++;
                zero = 0;
                maxOne = Math.max(maxOne, one);
            }
        }
        return maxOne > maxZero;
    }
}
