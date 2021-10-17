package com.markey.leetcode.one;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode128
 * @Author: markey
 * @Description:
 * @Date: 2021/7/13 20:51
 * @Version: 1.0
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        System.out.println(set);
        int res = 1;
        for (int x : set) {
            if (set.contains(x -1)) {
                // 重复的剪枝
                continue;
            }
            int max = 1;
            while (set.contains(x + 1)) {
                max++;
                x = x + 1;
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
