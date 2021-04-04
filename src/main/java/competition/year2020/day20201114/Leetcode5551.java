package competition.year2020.day20201114;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20201114
 * @ClassName: Leetcode5551
 * @Author: markey
 * @Description:
 * @Date: 2020/11/14 22:39
 * @Version: 1.0
 */
public class Leetcode5551 {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] numB = new int[n];
        int[] res = new int[n];
        if (s.charAt(0) == 'b') {
            numB[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                res[i] = res[i - 1];
                numB[i] = numB[i - 1] + 1;
            } else {
                if (numB[i - 1] > res[i - 1] + 1) {
                    res[i] = res[i - 1] + 1;
                    numB[i] = numB[i - 1];
                } else {
                    res[i] = numB[i - 1];
                    numB[i] = numB[i - 1];
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return res[n - 1];
    }
}
