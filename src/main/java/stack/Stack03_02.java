package stack;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack03_02
 * @Author: markey
 * @Description:
 * @Date: 2020/6/5 23:30
 * @Version: 1.0
 */
public class Stack03_02 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (!minStack.isEmpty() && minStack.peek() < x) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(x);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
