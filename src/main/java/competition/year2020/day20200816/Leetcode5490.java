package competition.year2020.day20200816;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20200816
 * @ClassName: Leetcode5490
 * @Author: markey
 * @Description:
 * @Date: 2020/8/16 11:43
 * @Version: 1.0
 */
public class Leetcode5490 {
    Map<Integer, Integer> map = new HashMap<>();
    public int minDays(int n) {
        System.out.println(n);
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int min = Integer.MAX_VALUE;
        min = Math.min(min, minDays(n / 2) + n % 2 + 1); // 关键点，这里的求余可以包含不被整除的情况
        min = Math.min(min, minDays(n / 3) + n % 3 + 1);
        map.put(n, min);
        return min;
    }
}
