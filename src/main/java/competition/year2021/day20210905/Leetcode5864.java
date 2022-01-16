package competition.year2021.day20210905;

import java.util.*;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210905
 * @ClassName: Leetcode5864
 * @Author: markey
 * @Description:
 * @Date: 2021/9/5 10:35
 * @Version: 1.0
 */
public class Leetcode5864 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int n = properties.length;
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        set.add(properties[0][1]);
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (set.first() > properties[i][1]) {
                count++;
            }
            set.add(properties[i][1]);
        }
        return count;
    }

}
