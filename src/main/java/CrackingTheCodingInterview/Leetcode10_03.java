package CrackingTheCodingInterview;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode10_03
 * @Author: markey
 * @Description:
 * @Date: 2020/10/2 10:41
 * @Version: 1.0
 */
public class Leetcode10_03 {
    // 题目没说清楚，旋转数组指的是吧第一个数字移到最后一位，不管旋转多少次，数组总能分成两部分递增序列
    // 二分查找
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            System.out.println("left:" + left + ", right:" + right);
            if (arr[left] == target) {
                return left;
            }
            int millde = (left + right) / 2;
            // 下面分不同情况进行处理
            if (arr[left] < arr[millde]) {
                // 递增序列
                if (target >= arr[left] && target <= arr[millde]) {
                    right = millde;
                } else {
                    left = millde + 1;
                }
            } else if (arr[left] > arr[millde]) {
                // 非递增序列，说明从left到right包含了两个递增序列 画下图就知道了
                if (target >= arr[left] || target <= arr[millde]) {
                    right = millde;
                    continue;
                } else {
                    left = millde + 1;
                }
            } else {
                // 特殊情况，因为有重复值
                if (arr[left] == target) {
                    right = left; // 跳出循环
                } else {
                    left = left + 1;
                }
            }
        }
        return arr[left] == target ? left : -1;
    }
}
