package com.markey.leetcode.four;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.four
 * @ClassName: Leetcode477
 * @Author: markey
 * @Description:
 * @Date: 2021/5/28 19:07
 * @Version: 1.0
 */
public class Leetcode477 {
    public int totalHammingDistance(int[] nums) {
        int[] bitCount = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int bit = 0;
            while (temp > 0) {
                bitCount[bit] += temp & 1;
                temp >>= 1;
                ++bit;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += bitCount[i] * (nums.length - bitCount[i]);
        }
        return res;
    }
}
