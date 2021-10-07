package competition.year2021.day20210123;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210123
 * @ClassName: Leetcode5647
 * @Author: markey
 * @Description:
 * @Date: 2021/1/23 23:08
 * @Version: 1.0
 */
public class Leetcode5647 {
    //超时，需要前缀异或和
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] res = new int[n];
        for (int i = n; i > 0; i--) {
            res[n - 1] = i;
            Set<Integer> existEven = new HashSet<>();
            Set<Integer> existOdd = new HashSet<>();
            if (i % 2 == 0) {
                existEven.add(i);
            } else {
                existOdd.add(i);
            }
            for (int j = n - 2; j >= 0; j--) {
                res[j] = res[j + 1] ^ encoded[j];
                if (existEven.contains(res[j]) || existOdd.contains(res[j]) || res[j] > n || res[j] <= 0) {
                    break;
                }
                if (res[j] % 2 == 0) {
                    existEven.add(res[j]);
                } else {
                    existOdd.add(res[j]);
                }
                if (existOdd.size() > n / 2 + 1 || existEven.size() > n / 2) {
                    break;
                }
            }
            if (res[0] > 0) {
                return res;
            }
        }
        return null;
    }
}
