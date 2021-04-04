package competition.year2020.day20200913;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200913
 * @ClassName: Leetcode5514
 * @Author: markey
 * @Description:
 * @Date: 2020/9/13 11:39
 * @Version: 1.0
 */
public class Leetcode5514 {
    public boolean isTransformable(String s, String t) {
        int start = 0;
        int end = s.length() - 1;
        System.out.println(s + ":" + t);
        while (end > 0 && s.charAt(end) == t.charAt(end)) {
            end--;
        }
        while (start <= end && s.charAt(start) == t.charAt(start)) {
            start++;
        }

        if (start > end) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(s.charAt(i) - '0');
        }
        list.sort(Integer::compareTo);
        System.out.println("List:" + list);

        if (0 == start && s.length() == end) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= list.size(); i++) {
                sb.append(list.get(i));
            }
            return isTransformable(sb.toString(), t.substring(start, end + 1));
        }
    }
}
