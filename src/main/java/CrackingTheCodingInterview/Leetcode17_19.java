package CrackingTheCodingInterview;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode17_19
 * @Author: markey
 * @Description:
 * @Date: 2020/10/11 18:19
 * @Version: 1.0
 */
public class Leetcode17_19 {
    public int[] missingTwo(int[] nums) {
        // 两次遍历，第一次遍历求出两数之和，第二次遍历求出较小的一个数
        int n = nums.length + 2;
        int sumAll = n * (n + 1) / 2; // 前n个数之和
        int sumHas = Arrays.stream(nums).sum(); // 数组之和
        int sumTwo = sumAll - sumHas; // 目标两个数之和
        int sumMiddle = sumTwo / 2; // 肯定一个数大于sumMillde，一个数小于sumMiddle

        int sumSmallThanMiddle = Arrays.stream(nums).filter(x -> x <= sumMiddle).sum(); // 前sumMiddle个数之和
        int small = sumMiddle * (sumMiddle + 1) / 2 - sumSmallThanMiddle; // 较小一个数
        int big = sumTwo - small;
        return new int[] {small, big};
    }
}
