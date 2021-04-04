package competition.year2020.day20200419;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200419
 * @ClassName: String5388
 * @Author: markey
 * @Description:
 * @Date: 2020/4/19 10:30
 * @Version: 1.0
 */
public class String5388 {
    public String reformat(String s) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (char c: s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                list1.add(c);
            } else {
                list2.add(c);
            }
        }

        if (Math.abs(list1.size() - list2.size()) > 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (!list1.isEmpty() && !list2.isEmpty()) {
            sb.append(list1.remove(0));
            sb.append(list2.remove(0));
        }

        if (!list1.isEmpty()) {
            sb.append(list1.get(0));
        }
        if (!list2.isEmpty()) {
            sb.insert(0, list2.get(0));
        }
        return sb.toString();
    }
}
