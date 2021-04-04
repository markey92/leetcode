package dynamicprogramming;

import java.util.Arrays;

/**
 * @ProjectName: leetcode
 * @Package: dynamicprogramming
 * @ClassName: Dp174
 * @Author: markey
 * @Description:
 * @Date: 2020/7/12 9:04
 * @Version: 1.0
 */
public class Dp174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 1;
        }
        /**
         * 从后往前进行状态转移
         * 每个位置至少有1个点才不会死亡、
         * 为了保证下个位置至少有x个点，则在上个位置时，至少有x-dungeon[i][j]个点，
         * 这里想不明白可以按dungeon[i][j]是正负两个情况想一想，结果都是x-dungeon[i][j]
         */
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] min = new int[m][n];
        // 初始化dp表
        min[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        for (int i = m - 2; i >= 0; i--) {
            min[i][n - 1] = Math.max(min[i + 1][n - 1] - dungeon[i][n - 1], 1); // 至少有1点
        }
        for (int i = n - 2; i >= 0; i--) {
            min[m - 1][i] = Math.max(min[m - 1][i + 1] - dungeon[m - 1][i], 1); // 至少有1点
        }
        // 状态转移
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int lastmin = Math.min(min[i + 1][j], min[i][j + 1]);
                min[i][j] = Math.max(lastmin - dungeon[i][j], 1);
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(min[i]));
        }
        return min[0][0];
    }
}
