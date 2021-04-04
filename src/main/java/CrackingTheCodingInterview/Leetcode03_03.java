package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode03_03
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 22:32
 * @Version: 1.0
 */
public class Leetcode03_03 {
    class StackOfPlates {
        int cap;
        List<Stack> stackList = new ArrayList<>();
        public StackOfPlates(int cap) {
            this.cap = cap;
        }

        public void push(int val) {
            if (cap == 0) {
                return;
            }
            if (!stackList.isEmpty()) {
                Stack stack = stackList.get(stackList.size() - 1);
                if (stack.size() < this.cap) {
                    stack.push(val);
                    return;
                }
            }
            Stack newStack = new Stack();
            newStack.push(val);
            stackList.add(newStack);
        }

        public int pop() {
            if (cap == 0 || stackList.isEmpty()) {
                return -1;
            }
            Stack<Integer> stack = stackList.get(stackList.size() - 1);
            int res = stack.pop();
            if (stack.isEmpty()) {
                stackList.remove(stack);
            }
            return res;
        }

        public int popAt(int index) {
            if (cap == 0 || index >= stackList.size()) {
                return -1;
            }
            Stack<Integer> stack = stackList.get(index);
            int res = stack.pop();
            if (stack.isEmpty()) {
                stackList.remove(stack);
            }
            return res;
        }
    }
}
