package competition.day20200502;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200502
 * @ClassName: Array5384
 * @Author: markey
 * @Description:
 * @Date: 2020/5/2 22:31
 * @Version: 1.0
 */
public class Array5384 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }
}
