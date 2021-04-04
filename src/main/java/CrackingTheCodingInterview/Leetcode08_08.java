package CrackingTheCodingInterview;

import java.util.*;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode08_08
 * @Author: markey
 * @Description:
 * @Date: 2020/10/28 20:37
 * @Version: 1.0
 */
public class Leetcode08_08 {
    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (char c : S.toCharArray()) {
            characters.add(c);
        }
        characters.sort(Character::compareTo);
        dfs(characters, new StringBuilder(), res);
        return res.toArray(new String[]{});
    }

    private void dfs(List<Character> characters, StringBuilder sb, List<String> res) {
        if (characters.isEmpty()) {
            res.add(sb.toString());
        }
        for (int i = 0; i < characters.size(); i++) {
            if (i > 0 && characters.get(i) == characters.get(i - 1)) {
                continue;
            }
            sb.append(characters.remove(i));
            dfs(characters, sb, res);
            characters.add(i, sb.charAt(sb.length() - 1));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
