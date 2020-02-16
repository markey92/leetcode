package lcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: lcof
 * @ClassName: LCOF50
 * @Author: markey
 * @Description:
 * @Date: 2020/2/16 22:04
 * @Version: 1.0
 */
public class LCOF50 {
    public char firstUniqChar(String s) {
        List<Character> list = new ArrayList<>();
        List<Character> removeChars = new ArrayList<>();
        for(char c: s.toCharArray()) {
            if (list.indexOf(c) != -1) {
                removeChars.add(list.remove(c));
                continue;
            }
            if (!removeChars.contains(c)) {
                list.add(c);
            }
        }
        return list.size() > 0 ? list.get(0) : ' ';
    }
}
