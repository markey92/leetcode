package competition.year2020.day20201108;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201108
 * @ClassName: Leetcode5561
 * @Author: markey
 * @Description:
 * @Date: 2020/11/8 10:30
 * @Version: 1.0
 */
public class Leetcode5561 {
    public int getMaximumGenerated(int n) {
        int[] array = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                array[i] = 0;
            }
            if (i == 1) {
                array[i] = 1;
            }
            if (2 <= i * 2 && i * 2 <= n) {
                array[i * 2] = array[i];
            }
            if (2 <= i * 2 + 1 && i * 2 + 1 <= n) {
                array[i * 2 + 1] = array[i] + array[i + 1];
            }
        }
        return Arrays.stream(array).max().getAsInt();
    }
}
