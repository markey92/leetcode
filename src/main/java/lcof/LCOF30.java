package lcof;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF30
 * @Author: markey
 * @Description:面试题30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/25 23:49
 * @Version: 1.0
 */
public class LCOF30 {
    /**
     * 使用两个栈，一个存所有数，一个单调递减
     */
    class MinStack {

        /** initialize your data structure here. */
        Stack<Integer> all, min;
        public MinStack() {
            all = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            all.push(x);
            if (min.isEmpty() || x <= min.peek()) {
                min.push(x);
            }
        }

        public void pop() {
            int x = all.pop();
            if (x == min.peek()) {
                min.pop();
            }
        }

        public int top() {
            return all.peek();
        }

        public int min() {
            return min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
