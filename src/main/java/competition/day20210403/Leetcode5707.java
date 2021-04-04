package competition.day20210403;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210403
 * @ClassName: Leetcode5707
 * @Author: markey
 * @Description:
 * @Date: 2021/4/3 23:04
 * @Version: 1.0
 */
public class Leetcode5707 {
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] remainder = new int[batchSize];
        for (int i = 0; i < groups.length; i++) {
            remainder[groups[i] % batchSize] ++;
        }
        System.out.println(Arrays.toString(remainder));
        int res = remainder[0];
        if (batchSize % 2 == 0) {
            res += remainder[batchSize / 2] / 2;
            remainder[batchSize / 2] = remainder[batchSize / 2] % 2;
        }

        System.out.println(res);
        for (int i = 1; i < (batchSize / 2); i++) {
            if (remainder[i] > 0 && remainder[batchSize - i] > 0) {
                int min = Math.min(remainder[i], remainder[batchSize - i]);
                remainder[i] -= min;
                remainder[batchSize - i] -= min;
                res += min;
            }
        }
        System.out.println(res);

        for (int i = 1; i < batchSize; i++) {
            int temp = 0;
            if (remainder[i] > 0) {
                if (temp % batchSize == 0) {
                    res++;
                }
                temp += remainder[i];
            }
        }
        return res;
    }
}
