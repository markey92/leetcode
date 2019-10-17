package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array674
 * @Author: markey
 * @Description:
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 23:03
 * @Version: 1.0
 */
public class Array674 {
    /**
     * Runtime: 1 ms, faster than 99.75% of Java online submissions for Longest Continuous Increasing Subsequence.
     * Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Longest Continuous Increasing Subsequence.
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                count++;
            } else {
                max = count > max ? count:max;
                count = 1;
            }
        }
        max = count > max ? count:max;
        return max;
    }
}
