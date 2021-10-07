package competition.year2021.day20210320;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210320
 * @ClassName: Leetcode5693
 * @Author: markey
 * @Description:
 * @Date: 2021/3/20 22:30
 * @Version: 1.0
 */
public class Leetcode5693 {
    public int secondHighest(String s) {
        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                list.add(c - '0');
            }
        }
        list = list.stream().distinct().sorted().collect(Collectors.toList());
        if (list.size() < 2) {
            return -1;
        } else {
            return list.get(list.size() - 2);
        }
    }
}
