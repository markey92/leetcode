package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array4
 * @Author: markey
 * @Description:4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/4/20 22:39
 * @Version: 1.0
 */
public class Array4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int midNum = (nums1.length + nums2.length) / 2;
        int num = 0;
        int nums1Index = 0, num2Index = 0;
        for (int i = 0; i < midNum; i++) {
            if (nums1Index >= nums1.length) {
                num = nums2[num2Index];
                num2Index++;
                continue;
            }
            if (num2Index >= nums2.length) {
                num = nums1[nums1Index];
                nums1Index++;
                continue;
            }
            if (nums1[nums1Index] < nums2[num2Index]) {
                num = nums1[nums1Index];
                nums1Index++;
            } else {
                num = nums2[num2Index];
                num2Index++;
            }
        }
        double res;
        if ((nums1.length + nums2.length) % 2 == 0) {
            if (nums1Index >= nums1.length) {
                res = (num + nums2[num2Index]) / 2;
            } else if (num2Index >= nums2.length) {
                res = (num + nums1[nums1Index]) / 2;
            } else {
                res = (num + Math.min(nums1[nums1Index], nums2[num2Index])) / 2.0;
            }
        } else {
            if (nums1Index >= nums1.length) {
                res = nums2[num2Index];
            } else if (num2Index >= nums2.length) {
                res = nums1[nums1Index];
            } else {
                res = Math.min(nums1[nums1Index], nums2[num2Index]);
            }
        }
        return res;
    }
}
