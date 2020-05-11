package math;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: math
 * @ClassName: Math268
 * @Author: markey
 * @Description:
 * @Date: 2020/5/11 22:44
 * @Version: 1.0
 */
public class Math268 {
    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        return n * (n + 1) / 2 - sum;
    }
}
