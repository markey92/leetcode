package stack;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack20
 * @Author: markey
 * @Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/17 23:19
 * @Version: 1.0
 */
public class Stack20 {

    /**
     * 执行用时 :36 ms, 在所有 java 提交中击败了7.26%的用户
     * 内存消耗 :36.2 MB, 在所有 java 提交中击败了38.67%的用户
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(stack.size());
            if (chars[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                    continue;
                }
            }
            if (chars[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                    continue;
                }
            }
            if (chars[i] == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                    continue;
                }
            }
            stack.push(chars[i]);
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
