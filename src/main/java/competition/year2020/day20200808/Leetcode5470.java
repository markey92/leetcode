package competition.year2020.day20200808;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200808
 * @ClassName: Leetcode5470
 * @Author: markey
 * @Description:
 * @Date: 2020/8/8 22:52
 * @Version: 1.0
 */
public class Leetcode5470 {
    public int minInsertions(String s) {
        // 将双右括号替换为_,则变为处理三种符号的情况
        s = s.replace("))", "_");
        Stack<Character> stack = new Stack<>();
        int num = 0;
        // 以下逻辑中，栈中元素只能是左括号
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 左括号没得说，只能入栈等待匹配
                stack.push(c);
            } else if (c == '_') {
                // _即两个右括号的情况，如果前面右(可以匹配则不用加字符，否则需要加一个(来实现括号平衡
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    num++;
                }
            } else {
                // 一个右括号的情况，如果栈空，则需要插入两个字符（左右括号）来实现括号平衡
                if (stack.isEmpty()) {
                    num += 2;
                } else {
                    // 栈不空，栈顶的一个括号，再插入一个右括号，可以实现括号平衡
                    stack.pop();
                    num += 1;
                }
            }
        }
        return num + stack.size() * 2; // 栈中剩下的左括号都需要加入两个右括号来实现括号平衡
    }
}
