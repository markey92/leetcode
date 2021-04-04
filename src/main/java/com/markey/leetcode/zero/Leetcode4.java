package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode4
 * @Author: markey
 * @Description:
 * @Date: 2020/6/26 10:24
 * @Version: 1.0
 */
public class Leetcode4 {
    // 二分法
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int lengthTotal = length1 + length2;
        if (lengthTotal % 2 == 1) {
            // 奇数个
            return findKthNum(nums1, nums2, lengthTotal / 2 + 1);
        } else {
            return (findKthNum(nums1, nums2, lengthTotal / 2)
                    + findKthNum(nums1, nums2, lengthTotal / 2 + 1)) / 2;
        }
    }

    // 找出两个排序数组中第k小的数
    private double findKthNum(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int start1 = 0;
        int start2 = 0;
        while (true) {
            // 特殊情况
            if (start1 == length1) {
                // 求num2数组的第k小的数字
                return nums2[start2 + k - 1];
            }
            if (start2 == length2) {
                // 求num1数组的第k小的数字
                return nums1[start1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(start1 + half, length1) - 1; // 保证数组不会越界
            int newIndex2 = Math.min(start2 + half, length2) - 1;
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= newIndex1 - start1 + 1;
                start1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - start2 + 1;
                start2 = newIndex2 + 1;
            }
        }
    }
    // 复杂度为 (m+n) / 2,从头往后同时遍历两个数组
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int midNum = (nums1.length + nums2.length) / 2;
        int num = 0;
        int nums1Index = 0, num2Index = 0;
        for (int i = 0; i < midNum; i++) {
            if (nums1Index >= nums1.length) {
                num = nums2[num2Index];
                num2Index++;
                continue;
            }
            if (num2Index >= nums2.length) {
                num = nums1[nums1Index];
                nums1Index++;
                continue;
            }
            if (nums1[nums1Index] < nums2[num2Index]) {
                num = nums1[nums1Index];
                nums1Index++;
            } else {
                num = nums2[num2Index];
                num2Index++;
            }
        }
        double res = 0.0;
        if ((nums1.length + nums2.length) % 2 == 0) {
            if (nums1Index >= nums1.length) {
                res = (num + nums2[num2Index]) / 2.0;
            } else if (num2Index >= nums2.length) {
                res = (num + nums1[nums1Index]) / 2.0;
            } else {
                res = (num + Math.min(nums1[nums1Index], nums2[num2Index])) / 2.0;
            }
        } else {
            if (nums1Index >= nums1.length) {
                res = nums2[num2Index];
            } else if (num2Index >= nums2.length) {
                res = nums1[nums1Index];
            } else {
                res = Math.min(nums1[nums1Index], nums2[num2Index]);
            }
        }
        return res;
    }
}
