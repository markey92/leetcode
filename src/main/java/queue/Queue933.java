package queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Queue933
 * @Author: markey
 * @Description:
 * 写一个 RecentCounter 类来计算最近的请求。
 *
 * 它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
 *
 * 返回从 3000 毫秒前到现在的 ping 数。
 *
 * 任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
 *
 * 保证每次对 ping 的调用都使用比之前更大的 t 值。
 *
 *  
 *
 * 示例：
 *
 * 输入：inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * 输出：[null,1,2,3,3]
 *  
 *
 * 提示：
 *
 * 每个测试用例最多调用 10000 次 ping。
 * 每个测试用例会使用严格递增的 t 值来调用 ping。
 * 每次调用 ping 都有 1 <= t <= 10^9。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-recent-calls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/6 11:15
 * @Version: 1.0
 */
public class Queue933 {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(1002));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

    static class RecentCounter {

        Queue<Integer> queue;
        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            while (!queue.isEmpty() && t - queue.peek()> 3000) {
                queue.poll();
            }
            queue.add(t);
            return queue.size();
        }
    }
}
