package lcof;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF31
 * @Author: markey
 * @Description:面试题31. 栈的压入、弹出序列
 *
 * @Date: 2020/2/27 23:54
 * @Version: 1.0
 */
public class LCOF31 {
    // 辅助栈进行模拟操作
    // 如果栈顶元素与出栈顺序一致则出栈，
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
