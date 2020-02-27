package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF53_2
 * @Author: markey
 * @Description:面试题53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date: 2020/2/27 22:29
 * @Version: 1.0
 */
public class LCOF53_2 {
    public int missingNumber(int[] nums) {
        int start = 0, end = nums.length - 1;
        int mid = (start + end) / 2;
        while (start < end) {
            if (nums[mid] == mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
            mid = (start + end) / 2;
        }
        return end;
    }
}
