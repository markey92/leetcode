package competition.day20200307;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200307
 * @ClassName: Window5337
 * @Author: markey
 * @Description:
 * @Date: 2020/3/7 22:44
 * @Version: 1.0
 */
public class Window5337 {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("leetcodeisgreat"));
    }
    public static int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c: s.toCharArray()) {
            if (is(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        if (isOk(map)) {
            return s.length();
        }
        int start = 0, end = s.length() - 1;
        int res = 0;
        while (start < end) {
            // 去掉第一个元音字符
            int temp = start;
            while (!is(s.charAt(start))) {
                start++;
            }
            map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
            if (isOk(map)) {
                res = Math.max(res, end - start);
            }
            map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
            // 去掉最后一个元音字符
            while (!is(s.charAt(end))) {
                end--;
            }
            map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            if (isOk(map)) {
                res = Math.max(res, end - temp);
            }
            map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
            // 首位元音都去掉
            map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
            map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            if (isOk(map)) {
                res = Math.max(res, end - start - 1);
            }
            start++;
            end--;
        }
        return res;

    }

    private static boolean isOk(Map<Character, Integer> map) {
        for (Character c: map.keySet()) {
            if (map.get(c) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean is(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
