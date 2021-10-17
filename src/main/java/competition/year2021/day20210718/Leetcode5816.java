package competition.year2021.day20210718;

/**
 * @ProjectName: leetcode
 * @Package: competition.day20210718
 * @ClassName: Leetcode5816
 * @Author: markey
 * @Description:
 * @Date: 2021/7/18 11:13
 * @Version: 1.0
 */
public class Leetcode5816 {
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int max = queries[i][0] ^ queries[i][1];
            int p = queries[i][0];
            while (parents[p] != -1) {
                p = parents[p];
                max = Math.max(max, queries[i][1] ^ p);
            }
            res[i] = max;
        }
        return res;
    }
}
