package competition.year2021.day20210124;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210124
 * @ClassName: Leetcode5664
 * @Author: markey
 * @Description:
 * @Date: 2021/1/24 11:32
 * @Version: 1.0
 */
public class Leetcode5664 {
    Map<Integer, Integer> cache = new HashMap<>();
    public int minimumBoxes(int n) {
        if (n < 4) {
            return n;
        }
        int sum = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            if (sum + fin(i) >= n) {
                return res + unFin(n - sum);
            }
            sum += fin(i);
            res += i;
        }
        return 0;
    }

    private int fin(int n) {
        return (n + 1) * n / 2;
    }

    private int unFin(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        for (int i = 0; i <= n; i++) {
            if (fin(i) >= n) {
                cache.put(n, i);
                return i;
            }
        }
        return 0;
    }
}
