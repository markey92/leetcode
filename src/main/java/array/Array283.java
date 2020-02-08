package array;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array283
 * @Author: markey
 * @Description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/8 16:14
 * @Version: 1.0
 */
public class Array283 {
    public static void main(String[] args) {
        moveZeroes(new int[] {1, 0});
    }
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 1;
        while (i < nums.length) {
            if (nums[i] == 0) {
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j >= nums.length) {
                    break;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
            i++;
            j = i+1;
        }
        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k]);
        }
    }
}
