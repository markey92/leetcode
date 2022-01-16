package competition.year2021.day20210808;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210808
 * @ClassName: Leetcode5840
 * @Author: markey
 * @Description:
 * @Date: 2021/8/8 10:41
 * @Version: 1.0
 */
public class Leetcode5840 {
    public static void main(String[] args) {
        Leetcode5840 leetcode5840 = new Leetcode5840();
        System.out.println(leetcode5840.minSwaps("][]["));
        System.out.println(leetcode5840.minSwaps("]]][[["));
        System.out.println(leetcode5840.minSwaps("[]"));
        System.out.println(leetcode5840.minSwaps("[[[]]]][][]][[]]][[["));
        System.out.println(leetcode5840.minSwaps("][][]["));
    }
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push('[');
            } else {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(']');
                }
            }
        }
        System.out.println(stack);
        return stack.size() / 2 / 2 + stack.size() / 2 % 2;
    }
}
