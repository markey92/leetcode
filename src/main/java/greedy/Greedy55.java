package greedy;

/**
 * @ProjectName: leetcode
 * @Package: greedy
 * @ClassName: Greedy55
 * @Author: markey
 * @Description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/1/5 10:31
 * @Version: 1.0
 */
public class Greedy55 {
    /**
     * Runtime: 214 ms, faster than 21.02% of Java online submissions for Jump Game.
     * Memory Usage: 40.8 MB, less than 52.99% of Java online submissions for Jump Game.
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int now = nums.length - 1;
        int next = now;
        while (now > 0) {
            for (int i = now; i >= 0; i--) {
                if (nums[i] >= now - i) {
                    next = i;
                }
            }
            if (next == now) {
                return false;
            } else {
                now = next;
            }
        }
        return true;
    }

    /**
     * Runtime: 1 ms, faster than 99.12% of Java online submissions for Jump Game.
     * Memory Usage: 41.4 MB, less than 32.48% of Java online submissions for Jump Game.
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int now = nums.length - 1;
        for (int i = now; i >= 0; i--) {
            if (nums[i] >= now - i) {
                now = i;
            }
        }
        return now == 0;
    }
}
