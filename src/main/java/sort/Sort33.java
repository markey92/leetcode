package sort;

/**
 * @ProjectName: leetcode
 * @Package: sort
 * @ClassName: Sort33
 * @Author: markey
 * @Description:
 * @Date: 2020/4/27 22:00
 * @Version: 1.0
 */
public class Sort33 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return -1;
        }
        if (start == end - 1) {
            return nums[start] == target ? start : -1;
        }
        int middle = (start + end) / 2;
        // 单调递增情况
        if (nums[end-1] > nums[start]) {
            if (target < nums[middle]) {
                return search(nums, start, middle, target);
            } else if (target > nums[middle]) {
                return search(nums, middle, end, target);
            } else {
                return middle;
            }
        } else {
            int left = search(nums, start, middle, target);
            int right = search(nums, middle, end, target);
            if (left != -1) {
                return left;
            } else {
                return right;
            }
        }
    }
}
