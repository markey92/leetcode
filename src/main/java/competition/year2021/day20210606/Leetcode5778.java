package competition.year2021.day20210606;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210606
 * @ClassName: Leetcode5778
 * @Author: markey
 * @Description:
 * @Date: 2021/6/6 10:47
 * @Version: 1.0
 */
public class Leetcode5778 {
    public int minFlips(String s) {
        int count = 0;
        while (count < s.length() && s.charAt(0) != s.charAt(s.length() - 1)) {
            s = s.substring(1) + s.charAt(0);
        }
        System.out.println(s);
        List<Integer> temp = new ArrayList<>();
        count = 0;
        for (int i = 1; i < s.length(); i++) {
            count++;
            if (s.charAt(i) == s.charAt(i - 1)) {
                temp.add(count);
                count = 0;
            }
            if (i == s.length() - 1) {
                temp.add(count + 1);
            }
        }
        System.out.println(temp);
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < temp.size(); i++) {
            if (i % 2 == 0) {
                res1 += temp.get(i);
            } else {
                res2 += temp.get(i);
            }
        }
        return Math.min(res1, res2);
    }
}
