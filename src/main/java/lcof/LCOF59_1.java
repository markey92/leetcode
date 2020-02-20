package lcof;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF59_1
 * @Author: markey
 * @Description:面试题59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/18 22:09
 * @Version: 1.0
 */
public class LCOF59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // k=0的情况
        if (k == 0) {
            return new int[] {};
        }
        // 求出第一个窗口的最大值,同时用双端队列保存单调递减数字
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        List<Integer> res = new ArrayList<>();
        res.add(queue.peek());
        // 遍历每个窗口
        for (int i = k; i < nums.length; i++) {
            // 如果移除窗口是值是最大值，则单调递减队列也要从头去掉一个数
            if (nums[i - k] == queue.peek()) {
                queue.poll();
            }
            // 单调递减队列进数,保证单调递减队列头永远是窗口内的最大值
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            // 单调递减队列头永远是窗口内的最大值
            res.add(queue.getFirst());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
