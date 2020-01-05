package string;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String767
 * @Author: markey
 * @Description:
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2019/10/7 22:48
 * @Version: 1.0
 */
public class String767 {

    public static void main(String[] args) {
        String S = "vvvlo";
//        System.out.println(reorganizeString(S));

        System.out.println(reorganizeString2(S));
    }

    public static String reorganizeString2(String S) {
        Map<Character, Integer> count = new HashMap<>();
        int max = 0;
        for (char c: S.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
            if (count.get(c) > max) {
                max = count.get(c);
            }
        }
        List<Character> keys = new ArrayList<>(count.keySet());
        keys.sort(new Comparator<Character>() {
            @Override
            public int compare(Character character, Character t1) {
                return count.get(t1) - count.get(character);
            }
        });
        System.out.println(keys);
        if (S.length() < max * 2 - 1) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        Stack<Character> result = new Stack<>();
        for (char c: keys) {
            for (int i = 0; i < count.get(c); i++) {
                while (!stack.isEmpty() && stack.peek() != result.peek()) {
                    result.push(stack.pop());
                }
                if (!result.isEmpty() && result.peek() == c) {
                    stack.push(c);
                    continue;
                }
                result.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }
        return sb.toString();
    }
    public static String reorganizeString(String S) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> result = new Stack<>();
        for (char c: S.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() != result.peek()) {
                result.push(stack.pop());
            }
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (!result.isEmpty() && result.peek() == c) {
                stack.push(c);
                continue;
            }
            result.push(c);
        }
        if (stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!result.isEmpty()) {
                sb.append(result.pop());
            }
            return sb.toString();
        } else {
            return "";
        }
    }
}