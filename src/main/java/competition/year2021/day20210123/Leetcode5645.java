package competition.year2021.day20210123;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210123
 * @ClassName: Leetcode5645
 * @Author: markey
 * @Description:
 * @Date: 2021/1/23 22:32
 * @Version: 1.0
 */
public class Leetcode5645 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int height = 0;
        for (int i = 0; i < gain.length; i++) {
            height += gain[i];
            max = Math.max(max, height);
        }
        return max;
    }
}
