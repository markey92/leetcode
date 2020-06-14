package set;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @ProjectName: leetcode
 * @Package: set
 * @ClassName: Set01_01
 * @Author: markey
 * @Description:
 * @Date: 2020/6/1 21:41
 * @Version: 1.0
 */
public class Set01_01 {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            set.add(astr.charAt(i));
        }
        return set.size() == astr.length();
    }
}
