package lcof;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF
 * @Author: markey
 * @Description:面试题57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *  
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/26 23:20
 * @Version: 1.0
 */
public class LCOF57 {
    /**
     * 从头往后遍历，并记录每个数，直到找到两个数相加等于target
     * 执行用时 :55 ms, 在所有 Java 提交中击败了19.24%的用户
     * 内存消耗 :57.8 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                return new int[] {nums[i], target - nums[i]};
            }
            set.add(nums[i]);
        }
        return new int[] {};
    }

    /**
     * 因为已经排好序了，所以可以用双指针，从前后向中间遍历，如果两数相加大于target就移动尾指针，否则移动首指针
     * 执行用时 :2 ms, 在所有 Java 提交中击败了99.80%的用户
     * 内存消耗 :55.9 MB, 在所有 Java 提交中击败了100.00%的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] + nums[j] == target) {
                return new int[] {nums[i], nums[j]};
            }
            if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] {};
    }
}
