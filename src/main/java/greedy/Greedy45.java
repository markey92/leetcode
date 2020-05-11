package greedy;

/**
 * @ProjectName: leetcode
 * @Package: greedy
 * @ClassName: Greedy45
 * @Author: markey
 * @Description:45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/4 9:02
 * @Version: 1.0
 */
public class Greedy45 {
    /**
     * 如果我们「贪心」地进行正向查找，每次找到可到达的最远位置，就可以在线性时间内得到最少的跳跃次数。
     *
     * 例如，对于数组 [2,3,1,2,4,2,3]，初始位置是下标 0，从下标 0 出发，最远可到达下标 2。下标 0 可到达的位置中，下标 1 的值是 3，从下标 1 出发可以达到更远的位置，因此第一步到达下标 1。
     *
     * 从下标 1 出发，最远可到达下标 4。下标 1 可到达的位置中，下标 4 的值是 4 ，从下标 4 出发可以达到更远的位置，因此第二步到达下标 4。
     *
     *
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int count = 0; // 跳跃次数
        int now = 0; // 当前所在位置，起始是0
        while (now < nums.length - 1) {
            int farest = 0; // 跳到下一个位置之后，可以到达的最远距离
            int next = now;
            // 当前位置可以到达的其他位置
            for (int i = 1; i <= nums[now]; i++) {
                // 求在可达到的位置上，哪个位置可以到达最远
                int index = now + i;
                if (index >= nums.length - 1) {
                    // 已经到达终点
                    next = index;
                    break;
                }
                // 找出哪个位置可以到达最远
                if (index + nums[index] > farest) {
                    farest = index + nums[index];
                    next = index;
                }
            }
            if (next == now) {
                // 说明没得跳了
                break;
            }
            now = next;
            count++;
        }
        if (now >= nums.length - 1) {
            // 到不了终点
            return -1;
        }
        return count;
    }
}
