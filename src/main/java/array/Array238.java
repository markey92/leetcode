package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array238
 * @Author: markey
 * @Description:238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/20 22:53
 * @Version: 1.0
 */
public class Array238 {
    // 使用前缀积、后缀积，注意处理首尾两个特殊场景
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[] {};
        }

        if (nums.length == 1) {
            return new int[] {0};
        }

        int[] preFix = new int[nums.length];
        preFix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preFix[i] = preFix[i-1] * nums[i];
        }

        int[] lastFix = new int[nums.length];
        lastFix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            lastFix[i] = lastFix[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        res[0] = lastFix[1];
        res[nums.length - 1] = preFix[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = preFix[i - 1] * lastFix[i + 1];
        }
        return res;
    }
}
