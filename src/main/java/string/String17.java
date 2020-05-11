package string;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String17
 * @Author: markey
 * @Description:17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/2 0:47
 * @Version: 1.0
 */
public class String17 {
    private static Map<Character, char[]> map;
    static {
        map = new HashMap<>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        if (digits.length() == 1) {
            char[] chars = map.get(digits.charAt(0));
            for (int i = 0; i < chars.length; i++) {
                res.add(String.valueOf(chars[i]));
            }
            return res;
        }
        List<String> temp = letterCombinations(digits.substring(1));
        temp.forEach(s -> {
            char[] chars = map.get(digits.charAt(0));
            for (int i = 0; i < chars.length; i++) {
                res.add(chars[i] + s);
            };
        });
        return res;
    }
}
