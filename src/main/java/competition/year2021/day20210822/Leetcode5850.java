package competition.year2021.day20210822;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210822
 * @ClassName: Leetcode5850
 * @Author: markey
 * @Description:
 * @Date: 2021/8/22 10:30
 * @Version: 1.0
 */
public class Leetcode5850 {
    public int findGCD(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int diff = max % min;
        while (diff != 0) {
            max = min;
            min = diff;
            diff = max % min;
        }
        return min;
    }
}
