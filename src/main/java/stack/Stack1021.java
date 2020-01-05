package stack;

import java.util.Stack;

public class Stack1021 {

    public static void main(String[] args) {
        String input = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(input));
    }
    public static String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        char[] chars = S.toCharArray();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            temp.append(chars[i]);
            if (chars[i] == '(') {
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] == ')' ) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.append(temp.substring(1, temp.length()-1));
                temp.delete(0, temp.length());
            }
        }
        return result.toString();
    }
}
