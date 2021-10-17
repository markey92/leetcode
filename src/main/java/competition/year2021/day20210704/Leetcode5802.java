package competition.year2021.day20210704;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210704
 * @ClassName: Leetcode5802
 * @Author: markey
 * @Description:
 * @Date: 2021/7/4 10:40
 * @Version: 1.0
 */
public class Leetcode5802 {
    static Map<Long, Long> cache = new HashMap<>();
    static {
        cache.put(1L, 5L);
        cache.put(2L, 20L);
    }
    public int countGoodNumbers(long n) {
        return (int) (count(n) % 1_000_000_007);
    }
    public long count(long n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long res = (count(n / 2)) * (count(n / 2 + n % 2)) % 1_000_000_007;
        cache.put(n, res);
        return res;
    }
}
