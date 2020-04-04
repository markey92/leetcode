package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: array
 * @ClassName: Array914
 * @Author: markey
 * @Description:
 * @Date: 2020/3/27 21:55
 * @Version: 1.0
 */
public class Array914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (map.isEmpty()) {
            return false;
        }
        int X = 0;
        for(int key: map.keySet()) {
            if (X == 0) {
                X = map.get(key);
                continue;
            }
            if (X != map.get(key)) {
                X = gcd(X, map.get(key));
            }
            if (X < 2) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
