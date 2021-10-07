package competition.year2021.day20210328;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210328
 * @ClassName: Leetcode5714
 * @Author: markey
 * @Description:
 * @Date: 2021/3/28 10:49
 * @Version: 1.0
 */
public class Leetcode5714 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        knowledge.forEach(item -> {
            map.put(item.get(0), item.get(1));
        });

        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                StringBuilder sb = new StringBuilder();
                Arrays.stream(stack.toArray()).forEach(item -> sb.append(item));
                sb.delete(0, 1);
                res.append(map.getOrDefault(sb.toString(), "?"));
                stack.clear();
                continue;
            }
            if (stack.isEmpty()) {
                res.append(c);
                continue;
            } else {
                stack.add(c);
            }
        }
        return res.toString();
    }
}
