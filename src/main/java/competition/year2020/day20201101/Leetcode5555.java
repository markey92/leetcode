package competition.year2020.day20201101;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201101
 * @ClassName: Leetcode5555
 * @Author: markey
 * @Description:
 * @Date: 2020/11/1 10:59
 * @Version: 1.0
 */
public class Leetcode5555 {
    public int countVowelStrings(int n) {
        int[] res = new int[5];
        for (int i = 0; i < 5; i++) {
            res[i] = 1;
        }
        while (n > 1) {
            for (int i = 1; i < 5; i++) {
                res[i] = res[i - 1] + res[i];
            }
            n--;
        }
        return Arrays.stream(res).sum();
    }
}
