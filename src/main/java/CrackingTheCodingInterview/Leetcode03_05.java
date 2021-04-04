package CrackingTheCodingInterview;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode03_05
 * @Author: markey
 * @Description: 用一个辅助栈实现单调栈
 * @Date: 2020/9/12 21:34
 * @Version: 1.0
 */
public class Leetcode03_05 {
    class SortedStack {
        private Stack<Integer> stack;
        public SortedStack() {
            this.stack = new Stack<>();
        }

        public void push(int val) {
            Stack<Integer> temp = new Stack<>();
            while (!this.stack.isEmpty() && this.stack.peek() < val) {
                temp.push(this.stack.pop());
            }
            this.stack.push(val);
            while (!temp.isEmpty()) {
                this.stack.push(temp.pop());
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                this.stack.pop();
            }
        }

        public int peek() {
            if (this.stack.isEmpty()) {
                return -1;
            }
            return this.stack.peek();
        }

        public boolean isEmpty() {
            return this.stack.isEmpty();
        }
    }
}
