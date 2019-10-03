package stack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Stack1190 {

    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
    public static String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Queue<Character> temp = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                while (stack.peek() != '(') {
                    temp.add(stack.pop());
                }
                stack.pop();
                while (!temp.isEmpty()) {
                    stack.push(temp.poll());
                }
            } else {
                stack.push(chars[i]);
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
