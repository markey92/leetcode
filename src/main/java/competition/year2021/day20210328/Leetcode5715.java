package competition.year2021.day20210328;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210328
 * @ClassName: Leetcode5715
 * @Author: markey
 * @Description:
 * @Date: 2021/3/28 10:43
 * @Version: 1.0
 */
public class Leetcode5715 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int count = 0;
        do {
            count++;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
            System.out.println(Arrays.toString(perm));
        } while (!check(perm));
        return count;
    }

    private boolean check(int[] perm) {
        for (int i = 0; i < perm.length; i++) {
            if (perm[i] != i) {
                return false;
            }
        }
        return true;
    }
}
