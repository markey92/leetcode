package competition.year2021.day20210228;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210228
 * @ClassName: Leetcode5691
 * @Author: markey
 * @Description:
 * @Date: 2021/2/28 11:13
 * @Version: 1.0
 */
public class Leetcode5691 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        System.out.println(sum1 + ":" + sum2);
        int res = Integer.MAX_VALUE;
        if (sum1 > sum2) {
            for (int i = 0; i <= sum1 - sum2; i++) {
                int add = add(nums2, i);
                if (add == -1) {
                    continue;
                }
                int delete = delete(nums1, sum1 - sum2 - i);
                if ( delete == -1) {
                    continue;
                }
                res = Math.min(res, add + delete);
                System.out.println(add + ":" + delete + "-" + res);
            }
        } else {
            for (int i = 0; i <= sum2 - sum1; i++) {
                int add = add(nums1, i);
                if (add == -1) {
                    continue;
                }
                int delete = delete(nums2, sum2 - sum1 - i);
                if (delete == -1) {
                    continue;
                }
                res = Math.min(res, add + delete);
            }
        }
        return res ==  Integer.MAX_VALUE ? -1 : res;
    }

    private int add(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target <= 0) {
                break;
            }
            if (nums[i] < 6) {
                target -= (6 - nums[i]);
                count++;
            }

        }
        return target <= 0 ? count : -1;
    }

    private int delete(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (target <= 0) {
                break;
            }
            if (nums[i] > 1) {
                target -= (nums[i] - 1);
                count++;
            }

        }
        return target <= 0 ? count : -1;
    }
}
