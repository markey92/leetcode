package com.markey.leetcode.one;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode1760
 * @Author: markey
 * @Description:
 * @Date: 2021/3/22 22:42
 * @Version: 1.0
 */
public class Leetcode1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 1_000_000_000;
        int res = 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(nums, mid, maxOperations)) {
                r = mid - 1;
                res = mid;
            } else {
                l = mid + 1;
            }
            System.out.println(l + ":" + r);
        }
        return res;
    }

    public boolean check(int[] nums, int max, int count) {
        int n = 0;
        for (int num: nums) {
            n += num % max == 0 ? num / max - 1 : num / max;
        }
        return n <= count;
    }

}
