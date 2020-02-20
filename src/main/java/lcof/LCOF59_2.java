package lcof;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF59_2
 * @Author: markey
 * @Description:面试题59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/18 23:01
 * @Version: 1.0
 */
public class LCOF59_2 {
    class MaxQueue {

        Deque<Integer> maxDeque;
        Queue<Integer> queue;
        public MaxQueue() {
            maxDeque = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public int max_value() {
            return maxDeque.isEmpty() ? -1 : maxDeque.getFirst();
        }

        public void push_back(int value) {
            while (!maxDeque.isEmpty() && maxDeque.getLast() < value) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(value);
            queue.offer(value);
        }

        public int pop_front() {
            int value = queue.isEmpty() ? -1 : queue.poll();
            if (!maxDeque.isEmpty() && value == maxDeque.getFirst()) {
                maxDeque.removeFirst();
            }
            return value;
        }
    }
}
