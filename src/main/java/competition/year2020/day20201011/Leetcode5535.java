package competition.year2020.day20201011;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201011
 * @ClassName: Leetcode5535
 * @Author: markey
 * @Description:
 * @Date: 2020/10/11 10:31
 * @Version: 1.0
 */
public class Leetcode5535 {
    public int maxDepth(String s) {
        int left = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
            } else {
                continue;
            }
            max = Math.max(max, left);
        }

        return max;
    }
}
