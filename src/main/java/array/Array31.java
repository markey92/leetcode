package array;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array31
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
 * @Date: 2020/5/3 19:37
 * @Version: 1.0
 */
public class Array31 {
    public void nextPermutation(int[] nums) {
        getNextPermutation(nums);
    }

    public static void getNextPermutation(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxJ = -1;
        int index = nums.length - 1;
        while( index >= 0){
            if( maxJ != -1 && max > nums[index] ){
                int minMax = findMinMax(nums,index);
                swap(nums,index,minMax);
                break;
            }
            if( nums[index] >= max ){
                max = nums[index];
                maxJ = index;
            }
            index--;
        }
        if( index != -1){
            Arrays.sort(nums,index+1,nums.length);
        }else {
            Arrays.sort(nums);
        }
    }

    private static int findMinMax(int[] nums, int index) {
        Arrays.sort(nums,index+1,nums.length);
        for (int i = index+1; i < nums.length; i++) {
            if( nums[i] > nums[index] ){
                return i;
            }
        }
        return -1;
    }

    public static void swap(int[] nums,int l ,int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
