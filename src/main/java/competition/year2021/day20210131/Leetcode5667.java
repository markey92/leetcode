package competition.year2021.day20210131;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210131
 * @ClassName: Leetcode5667
 * @Author: markey
 * @Description:
 * @Date: 2021/1/31 11:00
 * @Version: 1.0
 */
public class Leetcode5667 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] prefix = new long[n];
        prefix[0] = candiesCount[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + candiesCount[i];
        }
        System.out.println(Arrays.toString(prefix));

        int m = queries.length;
        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            long type = queries[i][0];
            long day = queries[i][1];
            long max = queries[i][2];

            long prefixType = prefix[(int) type];
            if (max * day > prefixType - candiesCount[(int) type] && day < prefixType) {
                res[i] = true;
            }
        }
        return res;
    }
}
