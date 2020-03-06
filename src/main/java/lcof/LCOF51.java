package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF51
 * @Author: markey
 * @Description:面试题51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/3/6 22:22
 * @Version: 1.0
 */
public class LCOF51 {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length, temp);
    }

    // 原数组进行归并排序，在归并过程中统计逆序对数
    // 注意：不重用temp数组的情况下会超内存、超时间
    public int mergeSort(int[] nums, int start, int end, int[] temp) {
        int middle = (start + end) / 2;

        int countLeft = start < middle ? mergeSort(nums, start, middle, temp) : 0; // 归并排序半个数组
        int countRight = (middle > start && middle < end) ? mergeSort(nums, middle, end, temp) : 0; // 归并排序右半个数组

        // 此次左右两半数组都是排序好的
        int leftIndex = start;
        int rightIndex = middle;
        int count = 0;
        for (int i = start; i < end; i++) {
            // 比较大小的四种情况
            if (leftIndex >= middle) {
                temp[i] = nums[rightIndex];
                rightIndex++;
            } else if (rightIndex >= end) {
                temp[i] = nums[leftIndex];
                leftIndex++;
            } else if (nums[leftIndex] <= nums[rightIndex]) {
                temp[i] = nums[leftIndex];
                leftIndex++;
            } else {
                temp[i] = nums[rightIndex];
                rightIndex++;
                // 此时nums[leftIndex] 到nums[middle]的数都比nums[rightIndex]大，都能组成逆序对；
                count += middle - leftIndex;
            }
        }
        // 要把temp的值填回nums中
        for (int i = start; i < end; i++) {
            nums[i] = temp[i];
        }
        return count + countLeft + countRight;
    }
}
