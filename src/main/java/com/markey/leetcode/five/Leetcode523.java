package com.markey.leetcode.five;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.five
 * @ClassName: Leetcode523
 * @Author: markey
 * @Description:
 * @Date: 2021/8/2 20:03
 * @Version: 1.0
 */
public class Leetcode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 前缀和除以k的余数相等，则相减之后是k的倍数
        Map<Integer, Integer> index = new HashMap<>();
        index.put(0, -1);
        int remainder = 0;
        // 从1开始，是因为题目要求子数组至少有两个
        for (int i = 1; i < nums.length; i++) {
            remainder = (remainder + nums[i]) % k;
            if (index.containsKey(remainder)) {
                if (i - index.get(remainder) > 1) {
                    return true;
                }
            } else {
                index.put(remainder, i);
            }
        }
        return false;
    }
}
