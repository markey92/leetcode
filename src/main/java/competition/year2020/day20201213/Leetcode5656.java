package competition.year2020.day20201213;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201213
 * @ClassName: Leetcode5656
 * @Author: markey
 * @Description:
 * @Date: 2020/12/13 10:36
 * @Version: 1.0
 */
public class Leetcode5656 {
    public int minPartitions(String n) {
        if (n.equals("0")) {
            return 0;
        }
        int max = 1;
        for (char c : n.toCharArray()) {
            max = Math.max(max, Integer.valueOf(c) - '0');
        }
        return max;
    }
}
