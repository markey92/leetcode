import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Stack5206 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
    public static String removeDuplicates(String s, int k) {
        if (k > s.length()) {
            return s;
        }

        char[] chars = s.toCharArray();
        Stack<Character> input = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            input.push(chars[i]);
        }
        Stack<Character> result = new Stack<>();
        char temp = input.pop();
        int sameNum = 1;
        while (!input.isEmpty()) {
            if (input.peek() == temp) {
                input.pop();
                sameNum++;
            } else {
                for (int i = 0; i < sameNum; i++) {
                    result.push(temp);
                }
                temp = input.pop();
                sameNum = 1;
            }
            if (sameNum == k) {
                for (int i = 0; !result.isEmpty() && i < k-1; i++) {
                    input.push(result.pop());
                }
                temp = input.pop();
                sameNum = 1;
            }
        }
        for (int i = 0; i < sameNum; i++) {
            result.push(temp);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!result.isEmpty()) {
            stringBuilder.append(result.pop());
        }
        return stringBuilder.toString();
    }
}
