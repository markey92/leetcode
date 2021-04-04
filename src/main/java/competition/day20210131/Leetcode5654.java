package competition.day20210131;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210131
 * @ClassName: Leetcode5654
 * @Author: markey
 * @Description:
 * @Date: 2021/1/31 10:32
 * @Version: 1.0
 */
public class Leetcode5654 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int temp = sum(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int res = 0;
        for (int value : map.values()) {
            res = Math.max(res, value);
        }
        return res;
    }

    private int sum(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n = n /10;
        }
        return res;
    }
}
