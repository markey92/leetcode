/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.93%)
 * Likes:    284
 * Dislikes: 0
 * Total Accepted:    52.1K
 * Total Submissions: 124.3K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 125/125 cases passed (7 ms)
Your runtime beats 81.62 % of java submissions
Your memory usage beats 84.07 % of java submissions (36.4 MB)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                if (Math.abs(nums[left] + nums[i] + nums[right] - target) < Math.abs(res - target)) {
                    res = nums[left] + nums[i] + nums[right];
                }
                if(nums[left] + nums[i] + nums[right] > target) {
                    right --;
                    continue;
                }
                if(nums[left] + nums[i] + nums[right] < target) {
                    left ++;
                    continue;
                }
                return nums[left] + nums[i] + nums[right];
            }
        }
        return res;
    }
}
// @lc code=end

