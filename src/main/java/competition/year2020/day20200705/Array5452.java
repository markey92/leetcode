package competition.year2020.day20200705;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200705
 * @ClassName: Array5452
 * @Author: markey
 * @Description:
 * @Date: 2020/7/5 10:30
 * @Version: 1.0
 */
public class Array5452 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int x = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != x) {
                return false;
            }
        }
        return true;
    }
}
