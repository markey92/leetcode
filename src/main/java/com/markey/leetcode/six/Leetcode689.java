package com.markey.leetcode.six;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.six
 * @ClassName: Leetcode689
 * @Author: markey
 * @Description:
 * @Date: 2021/12/8 8:01
 * @Version: 1.0
 */
public class Leetcode689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        // 求出长度为k的每个子数组的和
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int[] kSum = new int[n];
        kSum[0] = sum;
        for (int i = 1; i < n - k; i++) {
            sum = sum - nums[i - 1] + nums[i - 1 + k];
            kSum[i] = sum;
        }
        System.out.println(Arrays.toString(kSum));
        // 求出从左到右0-x的子数组最大和的开始下标
        int[] leftMaxIndex = new int[n];
        int leftMax = Integer.MIN_VALUE;
        for (int i = 0; i <= n - k; i++) {
            if (kSum[i] > leftMax) {
                leftMaxIndex[i] = i;
                leftMax = kSum[i];
            } else {
                leftMaxIndex[i] = i > 0 ? leftMaxIndex[i - 1] : 0;
            }
        }
        System.out.println(Arrays.toString(leftMaxIndex));
        // 求出冲右到左子数组最大和的开始下标
        int[] rightMaxIndex = new int[n];
        int rightMax = Integer.MIN_VALUE;
        for (int i = n - k; i >= 0; i--) {
            if (kSum[i] >= rightMax) {
                rightMaxIndex[i] = i;
                rightMax = kSum[i];
            } else {
                rightMaxIndex[i] = i < (n - k) ? rightMaxIndex[i + 1] : (n - k);
            }
        }
        System.out.println(Arrays.toString(rightMaxIndex));
        // 枚举中间数组开始坐标
        int indexOne = 0, indexTwo = 0, indexThree = 0;
        int sumMax = Integer.MIN_VALUE;
        for (int i = k; i < n - (2 * k - 1); i++) {
            int sumTemp = kSum[i] + kSum[leftMaxIndex[i - k]] + kSum[rightMaxIndex[i + k]];
            if (sumTemp > sumMax) {
                indexOne = leftMaxIndex[i - k];
                indexTwo = i;
                indexThree = rightMaxIndex[i + k];
                sumMax = sumTemp;
            }
            if (sumTemp == sumMax) {
                if (leftMaxIndex[i - k] < indexOne || i  < indexTwo || rightMaxIndex[i + k] < indexThree) {
                    indexOne = leftMaxIndex[i - k];
                    indexTwo = i;
                    indexThree = rightMaxIndex[i + k];
                }
            }
        }
        return new int[] {indexOne, indexTwo, indexThree};
    }
}
