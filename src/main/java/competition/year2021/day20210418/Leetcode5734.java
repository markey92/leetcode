package competition.year2021.day20210418;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210418
 * @ClassName: Leetcode5734
 * @Author: markey
 * @Description:
 * @Date: 2021/4/18 10:30
 * @Version: 1.0
 */
public class Leetcode5734 {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26;
    }
}
