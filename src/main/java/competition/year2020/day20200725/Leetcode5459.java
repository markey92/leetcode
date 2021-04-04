package competition.year2020.day20200725;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200725
 * @ClassName: Leetcode5459
 * @Author: markey
 * @Description:
 * @Date: 2020/7/25 23:01
 * @Version: 1.0
 */
public class Leetcode5459 {
    public int minNumberOperations(int[] target) {
        int pre = 0;
        int count = 0;
        for (int i = 0; i < target.length; i++) {
            int now = target[i];
            if (now == pre) {
                continue;
            } else if (now > pre) {
                count += now - pre;
                pre = now;
            } else {
                pre = now;
            }
        }
        return count;
    }
}
