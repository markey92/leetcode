import java.util.Stack;

public class Stack682 {
    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int number1 = Integer.parseInt(stack.pop());
                int number2 = Integer.parseInt(stack.pop());
                int number3 = number1 + number2;
                stack.push(String.valueOf(number2));
                stack.push(String.valueOf(number1));
                stack.push(String.valueOf(number3));
                continue;
            }
            if (ops[i].equals("D")) {
                int number1 = Integer.parseInt(stack.pop());
                int number2 = number1 * 2;
                stack.push(String.valueOf(number1));
                stack.push(String.valueOf(number2));
                continue;
            }
            if (ops[i].equals("C")) {
                stack.pop();
                continue;
            }
            stack.push(String.valueOf(ops[i]));
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += Integer.parseInt(stack.pop());
        }
        System.out.println(result);
    }
}
