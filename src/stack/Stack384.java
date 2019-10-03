package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Stack384
 * @Author: markey
 * @Description:
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/1 18:15
 * @Version: 1.0
 */
public class Stack384 {

    public static void main(String[] args) {
        String input = "3[a]2[b4[F]c]";
        System.out.println(decodeString2(input));
    }

    public static String decodeString2(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        List<Character> temp = new ArrayList<>();
        for (char c: chars) {
            System.out.println(stack);
            //数字入栈
            if ('0' <= c && c <= '9') {
                int num = c - '0';
                while (!stack.isEmpty() && isNumeric(stack.peek())) {
                    num += Integer.parseInt(stack.pop()) * 10;
                }
                stack.push(String.valueOf(num));
                continue;
            }
            if (c == '[') {
                stack.push(String.valueOf(c));
                continue;
            }
            if (c == ']') {
                String str = stack.pop(); //弹出字符串
                stack.pop(); //弹出“[”
                //弹出数字
                int times = stack.isEmpty() ? 1 : Integer.parseInt(stack.pop());
                //复制字符串
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    result.append(str);
                }
                //合并栈顶字符串
                if (!stack.isEmpty() && isString(stack.peek())) {
                    result.insert(0, stack.pop());
                }
                //将复制后的字符串重新入栈
                stack.push(result.toString());
                continue;
            }
            //字符入栈
            StringBuilder str = new StringBuilder();
            str.append(c);
            while (!stack.isEmpty() && isString(stack.peek())) {
                str.insert(0, stack.pop());
            }
            stack.push(str.toString());

        }
        return stack.isEmpty() ? "":stack.pop();
    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static boolean isString(String str){
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        return pattern.matcher(str).matches();
    }

    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Character> temp = new ArrayList<>();
        int times = 1;
        for (char c: chars) {
            if (c == ']') {
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp.add(0, stack.pop());
                }
                stack.pop(); // 弹出'['
                //弹出数字
                StringBuilder stringBuilder = new StringBuilder();
                while (!stack.isEmpty() && '0' <= stack.peek() && stack.peek() <= '9') {
                    stringBuilder.insert(0, String.valueOf(stack.pop()));
                }
                times = Integer.parseInt(stringBuilder.toString());
                //将字符重新入栈
                for (int i = 0; i < times; i++) {
                    for (char x : temp) {
                        stack.push(x);
                    }
                }
                temp.clear();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
