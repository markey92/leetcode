package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: string
 * @ClassName: String76
 * @Author: markey
 * @Description:76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2020/5/23 21:59
 * @Version: 1.0
 */
public class String76 {
    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }
    public static String minWindow(String s, String t) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char c: t.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }
        String res = s + t;
        Map<Character, Integer> windows = new HashMap<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            while (start <= end && hasAll(windows, chars)) {
                if (end - start + 1 < res.length()) {
                    res = s.substring(start, end + 1);
                }
                windows.put(s.charAt(start), windows.getOrDefault(s.charAt(start), 0) - 1);
                start++;
            }
            end++;
        }
        return res.length() > s.length() ? "" : res; // 没有符合子串，则res为初始值s+t
    }

    public static boolean hasAll(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (char key: map2.keySet()) {
            if (map1.getOrDefault(key, 0) < map2.get(key)) {
                return false;
            }
        }
        return true;
    }
}
