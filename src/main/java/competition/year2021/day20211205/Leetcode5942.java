package competition.year2021.day20211205;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20211205
 * @ClassName: Leetcode5942
 * @Author: markey
 * @Description:
 * @Date: 2021/12/5 10:31
 * @Version: 1.0
 */
public class Leetcode5942 {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < digits.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int x = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (x % 2 == 0) {
                        set.add(x);
                    }
                }
            }
        }
        int[] res = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(res);
        return res;
    }
}
