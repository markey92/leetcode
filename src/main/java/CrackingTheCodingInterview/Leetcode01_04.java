package CrackingTheCodingInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: CrackingTheCodingInterview
 * @ClassName: Leetcode01_04
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 17:22
 * @Version: 1.0
 */
public class Leetcode01_04 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        int oddNum = 0;
        for (char key : count.keySet()) {
            if (count.get(key) % 2 == 1) {
                oddNum ++;
            }
        }
        return oddNum < 2;
    }
}
