package com.markey.leetcode.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.three
 * @ClassName: Leetcode315
 * @Author: markey
 * @Description:
 * @Date: 2020/10/29 23:08
 * @Version: 1.0
 */
public class Leetcode315 {
    int[] C = new int[200001];
    private int lowBit(int n) {
        return n & (-n);
    }
    private void update(int i) {
        while (i < 100001) {
            C[i]++;
            i += lowBit(i);
        }
    }
    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += C[i];
            i -= lowBit(i);
        }
        return sum;
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] += 10000;
        }
        List<Integer> res = new ArrayList<>(n);
        for (int i = nums.length - 1; i >= 0; i--) {
            update(nums[i]);
            res.add(query(nums[i] - 1));
        }
        Collections.reverse(res);
        return res;
    }
}
