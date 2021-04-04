package com.markey.leetcode.five;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.five
 * @ClassName: Leetcode540
 * @Author: markey
 * @Description:
 * @Date: 2021/3/21 21:46
 * @Version: 1.0
 */
public class Leetcode540 {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
