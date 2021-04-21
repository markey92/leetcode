package interview.day20210421;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: interview.day20210421
 * @ClassName: Test2
 * @Author: markey
 * @Description:
 * @Date: 2021/4/21 20:18
 * @Version: 1.0
 */
public class Test2 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int second;
        int first;
        for (String token : tokens) {
            switch (token) {
                case "+" :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-" :
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first - second);
                    break;
                case "*" :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/" :
                    second = stack.pop();
                    first = stack.pop();
                    stack.push(first / second);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
