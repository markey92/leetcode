package lcof;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF21
 * @Author: markey
 * @Description:面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/20 22:50
 * @Version: 1.0
 */
public class LCOF21 {
    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,4};
        input = exchange(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
    public static int[] exchange(int[] nums) {
        int x = 0, y = nums.length - 1;
        while (x < y) {
            while (x < y && nums[x] % 2 == 1) {
                x++;
            }
            while (x < y && nums[y] % 2 == 0) {
                y--;
            }
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
            x++;
            y--;
        }
        return nums;
    }
}
