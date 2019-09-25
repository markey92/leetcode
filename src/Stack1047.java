import java.util.Stack;

public class Stack1047 {
    public static void main(String[] args) {
        String S = "abbaca";
        Stack<Character> stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty()) {
                char lastChar = stack.peek();
                if (lastChar == S.charAt(i)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(S.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        stack.forEach(character -> result.append(character));
        System.out.println(result);
    }
}
