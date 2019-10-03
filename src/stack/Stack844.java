package stack;

import java.util.Stack;

public class Stack844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }
    public static boolean backspaceCompare(String S, String T) {
        Stack stackS = getStack(S), stackT = getStack(T);
        if (stackS.size() != stackT.size()) {
            return false;
        }
        while (!stackS.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        return true;
    }

    public static Stack<Character> getStack(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(chars[i]);
            }
        }
        System.out.println(stack.size());
        return stack;
    }
}
