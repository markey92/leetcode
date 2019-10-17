package stack;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: stack
 * @ClassName: Stack856
 * @Author: markey
 * @Description:
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *  
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 *
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 *
 * 输入： "(()(()))"
 * 输出： 6
 *  
 *
 * 提示：
 *
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/18 0:23
 * @Version: 1.0
 */
public class Stack856 {

    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了89.63%的用户
     * 内存消耗 :33.9 MB, 在所有 java 提交中击败了89.09%的用户
     * @param S
     * @return
     */
    public int scoreOfParentheses(String S) {
        char[] chars = S.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int temp;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int m = stack.pop();
                stack.push(m + Math.max(v * 2, 1));
            }
        }

        return stack.pop();
    }
}
