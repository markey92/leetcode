package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array88
 * @Author: markey
 * @Description:
 * @Date: 2020/2/8 17:45
 * @Version: 1.0
 */
public class Array88 {

    /**
     * 方法三 : 双指针 / 从后往前
     * 直觉
     *
     * 方法二已经取得了最优的时间复杂度O(n + m)O(n+m)，但需要使用额外空间。这是由于在从头改变nums1的值时，需要把nums1中的元素存放在其他位置。
     *
     * 如果我们从结尾开始改写 nums1 的值又会如何呢？这里没有信息，因此不需要额外空间。
     *
     * 这里的指针 p 用于追踪添加元素的位置。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (m <= 0) {
                nums1[i] = nums2[--n];
                continue;
            }
            if (n <= 0) {
                nums1[i] = nums1[--m];
                continue;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[i] = nums1[--m];
            } else {
                nums1[i] = nums2[--n];
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int start = 0;
        for (int i = 0; i < n; i++) {
            for ( ;start < m; start++) {
                if (nums1[start] > nums2[i]) {
                    break;
                }
            }
            backOne(nums1, start);
            nums1[start] = nums2[i];
            start++;
        }
    }

    public void backOne(int[] nums, int i) {
        int end = nums.length - 1;
        while (end > i) {
            nums[end] = nums[end - 1];
            end--;
        }
    }
}
