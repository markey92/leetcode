package competition.year2021.day20210613;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210613
 * @ClassName: Leetcode5785
 * @Author: markey
 * @Description:
 * @Date: 2021/6/13 10:56
 * @Version: 1.0
 */
public class Leetcode5785 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                set.add(triplets[i]);
            }
        }
        boolean x = false, y = false, z = false;
        for (int[] item : set) {
            if (item[0] == target[0]) {
                x = true;
            }
            if (item[1] == target[1]) {
                y = true;
            }
            if (item[2] == target[2]) {
                z = true;
            }
        }
        return (x && y && z);
    }
}
