package competition.year2020.day20201122;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201122
 * @ClassName: Leetcode5607
 * @Author: markey
 * @Description:
 * @Date: 2020/11/22 10:41
 * @Version: 1.0
 */
public class Leetcode5607 {
    public int waysToMakeFair(int[] nums) {
        if (nums.length < 2) {
            return 1;
        }
        int n = nums.length;
        int[] leftSumOdd = new int[n];
        int[] leftSumEven = new int[n];
        leftSumOdd[0] = 0;
        leftSumEven[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                leftSumOdd[i] = leftSumOdd[i - 1] + nums[i];
                leftSumEven[i] = leftSumEven[i - 1];
            } else {
                leftSumEven[i] = leftSumEven[i - 1] + nums[i];
                leftSumOdd[i] = leftSumOdd[i - 1];
            }
        }
        System.out.println(Arrays.toString(leftSumOdd));
        System.out.println(Arrays.toString(leftSumEven));

        int[] rightSumOdd = new int[n];
        int[] rightSumEven = new int[n];
        if ((n - 1) % 2 == 1) {
            rightSumOdd[n - 1] = nums[n - 1];
            rightSumEven[n - 1] = 0;
        } else {
            rightSumEven[n - 1] = nums[n - 1];
            rightSumOdd[n - 1] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (i % 2 == 1) {
                rightSumOdd[i] = rightSumOdd[i + 1] + nums[i];
                rightSumEven[i] = rightSumEven[i + 1];
            } else {
                rightSumEven[i] = rightSumEven[i + 1] + nums[i];
                rightSumOdd[i] = rightSumOdd[i + 1];
            }
        }
        System.out.println(Arrays.toString(rightSumOdd));
        System.out.println(Arrays.toString(rightSumEven));

        int res = 0;
        if (leftSumOdd[n - 2] == leftSumEven[n - 2]) {
            System.out.println("a");
            res++;
        }
        if (rightSumOdd[1] == rightSumEven[1]) {
            System.out.println("b");
            res++;
        }
        for (int i = 1; i < n - 1; i++) {
            if (leftSumOdd[i - 1] + rightSumEven[i + 1] == leftSumEven[i - 1] + rightSumOdd[i + 1]) {
                res++;
            }
        }
        return res;
    }
}
