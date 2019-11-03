import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (24.32%)
 * Likes:    1483
 * Dislikes: 0
 * Total Accepted:    113K
 * Total Submissions: 464.6K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 313/313 cases passed (30 ms)
     * Your runtime beats 99.53 % of java submissions
     * Your memory usage beats 95.74 % of java submissions (46.7 MB)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while(left < right) {
                if(nums[left] + nums[i] + nums[right] > 0) {
                    right --;
                    continue;
                }
                if(nums[left] + nums[i] + nums[right] < 0) {
                    left ++;
                    continue;
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                right --;
                left ++;
                //去重
                while(right > 0 && nums[right + 1] == nums[right]) {
                    right --;
                }
                while(left < nums.length - 1 && nums[left - 1] == nums[left]) {
                    left++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

