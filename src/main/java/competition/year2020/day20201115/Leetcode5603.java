package competition.year2020.day20201115;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201115
 * @ClassName: Leetcode5603
 * @Author: markey
 * @Description:
 * @Date: 2020/11/15 10:37
 * @Version: 1.0
 */
public class Leetcode5603 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Set<Character> set1 = new HashSet<>();
        int[] chars1 = new int[26];
        for (char c : word1.toCharArray()) {
            chars1[c - 'a']++;
            set1.add(c);
        }
        Arrays.sort(chars1);

        Set<Character> set2 = new HashSet<>();
        int[] chars2 = new int[26];
        for (char c : word2.toCharArray()) {
            chars2[c - 'a']++;
            set2.add(c);
        }
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }

        return set1.equals(set2);
    }
}
