package competition.year2020.day20200823;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200823
 * @ClassName: Leetcode5495
 * @Author: markey
 * @Description:
 * @Date: 2020/8/23 10:32
 * @Version: 1.0
 */
public class Leetcode5495 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int i = rounds.length;
        int last = rounds[i - 1];
        int first = rounds[0];
        List<Integer> res = new ArrayList<>();
        if (first < last) {
            for (int j = first; j <= last; j++) {
                res.add(j);
            }
        } else if (first > last){
            for (int j = first; j <= n; j++) {
                res.add(j);
            }
            for (int j = 1; j <= last; j++) {
                res.add(j);
            }
        } else {
            res.add(last);
        }
        Collections.sort(res);
        return res;
    }
}
