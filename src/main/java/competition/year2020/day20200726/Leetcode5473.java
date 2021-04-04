package competition.year2020.day20200726;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200726
 * @ClassName: Leetcode5473
 * @Author: markey
 * @Description:
 * @Date: 2020/7/26 10:36
 * @Version: 1.0
 */
public class Leetcode5473 {
    public int minFlips(String target) {
        int count = 0;
        if (target.charAt(0) == '1') {
            count++;
        }
        for (int i = 1; i < target.length(); i++) {
            if (target.charAt(i) != target.charAt(i - 1)) {
                count++;
            }
        }
        return count;
    }
}
