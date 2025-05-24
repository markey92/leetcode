package lcof;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF58_1
 * @Author: markey
 * @Description:面试题58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/2/27 23:14
 * @Version: 1.0
 */
public class LCOF58_1 {

    public String reverseWords1(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i].length() > 0) {
                sb.append(" ");
                sb.append(array[i]);
            }
        }
        return sb.length() == 0 ? "" : sb.toString().substring(1);
    }

    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        StringBuilder word = new StringBuilder();
        for (int i = s.length() - 1; i >=0 ; i--) {
            if (s.charAt(i) != ' ') {
                stack.add(s.charAt(i));
            }

            if (s.charAt(i) == ' ' || i == 0) {
                while (!stack.isEmpty()) {
                    word.append(stack.pop());
                }
                if (word.length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(word.toString());
                    word.delete(0, word.length());
                }
            }
        }
        return stringBuilder.length() == 0 ? "" : stringBuilder.toString().substring(1);
    }
}
