package competition.day20200530;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200530
 * @ClassName: Array5408
 * @Author: markey
 * @Description:
 * @Date: 2020/5/30 22:31
 * @Version: 1.0
 */
public class Array5408 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
