package competition.year2020.day20200705;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200705
 * @ClassName: Num5453
 * @Author: markey
 * @Description:
 * @Date: 2020/7/5 11:37
 * @Version: 1.0
 */
public class Num5453 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max = 0;
        for (int i = 0; i < left.length; i++) {
            max = Math.max(max, left[i]);
        }
        for (int i = 0; i < right.length; i++) {
            max = Math.max(max, n - right[i]);
        }
        return max;
    }
}
