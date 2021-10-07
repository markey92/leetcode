package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.eight
 * @ClassName: Leetcode81
 * @Author: markey
 * @Description:
 * @Date: 2021/4/7 7:42
 * @Version: 1.0
 */
public class Leetcode81 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 2));
    }
    public static boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static boolean search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return false;
        }
        if (nums[start] < nums[end]) {
            if (target < nums[start] || target > nums[end]) {
                return false;
            } else {
                int middle = start + (end - start) / 2;
                if (nums[middle] == target) {
                    return true;
                } else if (nums[middle] > target) {
                    return search(nums, target, start, middle - 1);
                } else {
                    return search(nums, target, middle + 1, end);
                }
            }
        } else {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return true;
            }
            return search(nums, target, start, middle - 1) || search(nums, target, middle + 1, end);
        }
    }
}
