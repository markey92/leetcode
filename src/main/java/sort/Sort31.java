package sort;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: Sort31
 * @Author: markey
 * @Description:31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/26 21:58
 * @Version: 1.0
 */
public class Sort31 {
    // 特殊排序
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        // 第一步，从尾向前，找到第一个比后面的数大的下标
        int index = nums.length - 2;
        for (; index >= 0 ; index--) {
            if (nums[index] < nums[index+1]) {
                break;
            }
        }
        // 第二步，从尾向前,找到第一个比index大的数
        int tail = nums.length - 1;
        while (index > -1 && tail > index) {
            if (nums[tail] > nums[index]) {
                int temp = nums[index];
                nums[index] = nums[tail];
                nums[tail] = temp;
                break;
            }
            tail--;
        }
        System.out.println(Arrays.toString(nums));
        // 将剩下的index+1到尾部的递减序列倒序
        int start = index + 1;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
