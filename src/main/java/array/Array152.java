package array;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array152
 * @Author: markey
 * @Description:
 * @Date: 2020/5/18 22:42
 * @Version: 1.0
 */
public class Array152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] positiveProducts = new int[nums.length];
        int[] negativeProducts = new int[nums.length];
        positiveProducts[0] = nums[0];
        negativeProducts[0] = nums[0];
        int max = positiveProducts[0];
        // 分正负讨论
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveProducts[i] = positiveProducts[i - 1] > 0 ? positiveProducts[i - 1] * nums[i] : nums[i];
                negativeProducts[i] = negativeProducts[i - 1] < 0 ? negativeProducts[i - 1] * nums[i] : nums[i];
            } else {
                positiveProducts[i] = negativeProducts[i - 1] < 0 ? negativeProducts[i - 1] * nums[i] : nums[i];
                negativeProducts[i] = positiveProducts[i - 1] > 0 ? positiveProducts[i - 1] * nums[i] : nums[i];
            }

            max = Math.max(max, positiveProducts[i]);
        }
        System.out.println(Arrays.toString(positiveProducts));
        System.out.println(Arrays.toString(negativeProducts));
        return max;
    }
}
