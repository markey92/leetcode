package stack;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack224
 * @Author: markey
 * @Description:
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/12/11 20:24
 * @Version: 1.0
 */
public class Stack224 {
    public static void main(String[] args) {
        calculate("1+2");
    }
    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        int temp = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            switch (c) {
                case ')' :
                    if (temp != 0) {
                        stack.push(Integer.toString(temp));
                        temp = 0;
                    }
                    stack.push("(");
                    break;
                case '+' :
                    if (temp != 0) {
                        stack.push(Integer.toString(temp));
                        temp = 0;
                    }stack.push("+");
                    break;
                case '-' :
                    if (temp != 0) {
                        stack.push(Integer.toString(temp));
                        temp = 0;
                    }
                    stack.push("-");
                    break;
                case '(' :
                    calculateSome(stack);
                    break;
                default:
                    temp = temp * 10 + c - '0';
            }
        }
        return Integer.parseInt(stack.pop());
    }

    private static void calculateSome(Stack<String> stack) {
        int temp = Integer.parseInt(stack.pop());
        if (!stack.isEmpty()) {
            while (stack.peek() != ")") {
                if (stack.pop() == "+") {
                    temp += Integer.parseInt(stack.pop());
                    continue;
                }
                if (stack.pop() == "-") {
                    temp -= Integer.parseInt(stack.pop());
                    continue;
                }
            }
            stack.pop();
        }
        stack.push(Integer.toString(temp));
    }
}
