package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array575
 * @Author: markey
 * @Description:
 * @Date: 2020/5/27 22:01
 * @Version: 1.0
 */
public class Array575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            set.add(candies[i]);
        }
        if (set.size() > candies.length / 2) {
            return candies.length / 2;
        } else {
            return set.size();
        }
    }
}
