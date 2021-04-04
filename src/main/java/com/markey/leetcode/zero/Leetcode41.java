package com.markey.leetcode.zero;

/**
 * @ProjectName: leetcode
 * @Package: com.markey.leetcode.one
 * @ClassName: Leetcode41
 * @Author: markey
 * @Description:
 * @Date: 2020/6/27 11:09
 * @Version: 1.0
 */
public class Leetcode41 {
    /**
     * 「真正」满足此要求的算法是不存在的。但是我们可以退而求其次：利用给定数组中的空间来存储一些状态。也就是说，如果题目给定的数组是不可修改的，那么就不存在满足时空复杂度要求的算法；但如果我们可以修改给定的数组，那么是存在满足要求的算法的。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 首先，符合题意的数字肯定在[1,N+1]中，N为数组长度
     * 所以可以利用原数组来保存某个值是否出现过，
     * 1、将数组所有数字变为正数， 负数取反后再加上N；
     * 2、从前往后遍历，如果数字小于N+1，则将对应下表的元素取负，
     * 3、如果数字为负，说明当前下标被标记过而已，将其取正后正常处理
     *
     * 4、最后再遍历一次，看看哪个下标的值还是正数，说明没有被标记过，即为答案，
     * 5、如果都被标记过，则答案是N+1；
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 处理非正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = 2 * n - nums[i];
            }
        }
        // 通过标记来记录[1,n]有没有出现过
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            if (temp < 0) {
                temp = 0 - temp;
            }
            // 经过处理，temp >= 0; 0和>0的值不需要处理，不可能是答案
            if (temp > 0 && temp <= n && nums[temp - 1] > 0) {
                nums[temp - 1] = 0 - nums[temp - 1];
            }
        }
        // 看看哪个下标没有被标记，即为答案，全部被标记，则答案是N+1
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
